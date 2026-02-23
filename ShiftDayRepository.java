package com.example.security.repository;

import com.example.security.entity.ShiftDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ShiftDayRepository extends JpaRepository<ShiftDay, Long> {

    Optional<ShiftDay> findByShiftDate(LocalDate date);

    ShiftDay findTopByOrderByShiftDateDesc();
}
