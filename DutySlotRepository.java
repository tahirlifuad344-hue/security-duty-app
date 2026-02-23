package com.example.security.repository;

import com.example.security.entity.DutySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutySlotRepository extends JpaRepository<DutySlot, Long> {

    List<DutySlot> findByTemplateId(Long templateId);

    List<DutySlot> findByRequiredRoleCode(String roleCode);
}
