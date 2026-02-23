package com.example.security.repository;

import com.example.security.entity.EmployeeUnavailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeUnavailabilityRepository
        extends JpaRepository<EmployeeUnavailability, Long> {

    List<EmployeeUnavailability> findByEmployeeId(Long employeeId);

    @Query("""
           SELECT u FROM EmployeeUnavailability u
           WHERE u.employee.id = :employeeId
           AND :date BETWEEN u.startAt AND u.endAt
           """)
    List<EmployeeUnavailability> findActiveUnavailability(
            @Param("employeeId") Long employeeId,
            @Param("date") LocalDateTime date);
}
