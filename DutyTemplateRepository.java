package com.example.security.repository;

import com.example.security.entity.DutyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyTemplateRepository extends JpaRepository<DutyTemplate, Long> {

    List<DutyTemplate> findByIsActiveTrue();
}
