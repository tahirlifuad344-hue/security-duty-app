package com.example.security.service;

import com.example.security.entity.Employee;
import com.example.security.entity.PostType;
import com.example.security.entity.ShiftAssignment;
import com.example.security.entity.ShiftDay;
import com.example.security.repository.EmployeeRepository;
import com.example.security.repository.ShiftAssignmentRepository;
import com.example.security.repository.ShiftDayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ShiftService {

    private final EmployeeRepository employeeRepository;
    private final ShiftDayRepository shiftDayRepository;
    private final ShiftAssignmentRepository assignmentRepository;

    @Transactional
    public void generateDailyShift(LocalDate date) {

        if (shiftDayRepository.findByShiftDate(date).isPresent()) {
            throw new RuntimeException("Shift already exists for this date");
        }

        List<Employee> employees = employeeRepository.findByActiveTrue();

        if (employees.size() < 11) {
            throw new RuntimeException("Not enough employees");
        }

        Collections.shuffle(employees);

        // əvvəlki günün supervisorunu tapırıq
        ShiftDay lastDay = shiftDayRepository.findTopByOrderByShiftDateDesc();

        AtomicReference<Employee> lastSupervisor = new AtomicReference<>();

        if (lastDay != null) {
            assignmentRepository
                    .findByShiftDayAndPostType(lastDay, PostType.SUPERVISOR)
                    .ifPresent(a -> lastSupervisor.set(a.getEmployee()));
        }

        Employee newSupervisor = employees.stream().filter(e -> !e.equals(lastSupervisor)).findFirst().orElse(null);

        ShiftDay shiftDay = new ShiftDay();
        shiftDay.setShiftDate(date);
        shiftDay = shiftDayRepository.save(shiftDay);

        saveAssignment(newSupervisor, PostType.SUPERVISOR, shiftDay);

        int index = 0;
        List<Employee> selected = employees.stream()
                .filter(e -> !e.equals(newSupervisor))
                .limit(10)
                .toList();

        saveGroup(selected.subList(0,3), PostType.POST1, shiftDay);
        saveGroup(selected.subList(3,5), PostType.POST2, shiftDay);
        saveGroup(selected.subList(5,7), PostType.POST3, shiftDay);
        saveGroup(selected.subList(7,10), PostType.POST4, shiftDay);
    }

    private void saveGroup(List<Employee> list, PostType type, ShiftDay day) {
        for (Employee e : list) {
            saveAssignment(e, type, day);
        }
    }

    private void saveAssignment(Employee e, PostType type, ShiftDay day) {
        ShiftAssignment assignment = new ShiftAssignment();
        assignment.setEmployee(e);
        assignment.setPostType(type);
        assignment.setShiftDay(day);
        assignmentRepository.save(assignment);
    }
}

