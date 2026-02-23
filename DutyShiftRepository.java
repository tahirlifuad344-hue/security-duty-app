package com.example.security.repository;

import com.example.security.entity.DutyShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DutyShiftRepository extends JpaRepository<DutyShift, Long> {

    List<DutyShift> findByTemplateId(Long templateId);

    List<DutyShift> findByStartAtBetween(LocalDateTime start, LocalDateTime end);
}
