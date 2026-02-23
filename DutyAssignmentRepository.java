package com.example.security.repository;

import com.example.security.entity.DutyAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyAssignmentRepository extends JpaRepository<DutyAssignment, Long> {

    List<DutyAssignment> findByShiftId(Long shiftId);

    List<DutyAssignment> findByEmployeeId(Long employeeId);

    boolean existsByShiftIdAndSlotId(Long shiftId, Long slotId);
}

