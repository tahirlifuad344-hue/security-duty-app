package com.example.security.service.impl;

import com.example.security.dto.EmployeeRequestDto;
import com.example.security.dto.EmployeeResponseDto;
import com.example.security.entity.Employee;
import com.example.security.repository.EmployeeRepository;
import com.example.security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto dto) {

        Employee employee = new Employee();
        employee.setCode(dto.getCode());
        employee.setFullName(dto.getFullName());
        employee.setStatus(dto.getStatus());

        Employee saved = repository.save(employee);

        return mapToResponse(saved);
    }

    @Override
    public List<EmployeeResponseDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto getById(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return mapToResponse(employee);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // 🔥 Mapping Method (Professional üsul)
    private EmployeeResponseDto mapToResponse(Employee employee) {

        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setCode(employee.getCode());
        dto.setFullName(employee.getFullName());
        dto.setStatus(employee.getStatus());
        dto.setCreatedAt(employee.getCreatedAt());

        return dto;
    }
}
