package com.example.security.repository;

import com.example.security.entity.Employee;
import com.example.security.entity.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByCode(String code);

    boolean existsByCode(String code);

    List<Employee> findByStatus(EmployeeStatus status);

    List<Employee> findByActiveTrue();
}


