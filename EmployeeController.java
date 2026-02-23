package com.example.security.controller;

import com.example.security.dto.EmployeeRequestDto;
import com.example.security.dto.EmployeeResponseDto;
import com.example.security.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public EmployeeResponseDto create(@RequestBody EmployeeRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<EmployeeResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

