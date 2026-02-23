package com.example.security.repository;

import com.example.security.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {

    List<EmployeeRole> findByEmployeeId(Long employeeId);

    List<EmployeeRole> findByRoleId(Long roleId);

    boolean existsByEmployeeIdAndRoleId(Long employeeId, Long roleId);
}
