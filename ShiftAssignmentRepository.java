package com.example.security.repository;

import com.example.security.entity.PostType;
import com.example.security.entity.ShiftAssignment;
import com.example.security.entity.ShiftDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShiftAssignmentRepository extends JpaRepository<ShiftAssignment, Long> {

    List<ShiftAssignment> findByShiftDay(ShiftDay shiftDay);

    Optional<ShiftAssignment> findByShiftDayAndPostType(ShiftDay day, PostType type);
}

