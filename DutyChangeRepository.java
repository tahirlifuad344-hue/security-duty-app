package com.example.security.repository;

import com.example.security.entity.DutyChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyChangeRepository extends JpaRepository<DutyChange, Long> {

    List<DutyChange> findByShiftId(Long shiftId);
}

