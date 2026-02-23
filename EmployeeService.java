package com.example.security.service;

import com.example.security.dto.EmployeeRequestDto;
import com.example.security.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto create(EmployeeRequestDto dto);

    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto getById(Long id);

    void delete(Long id);
}
