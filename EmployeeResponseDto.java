package com.example.security.dto;

import com.example.security.entity.EmployeeStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeResponseDto {

    private Long id;
    private String code;
    private String fullName;
    private EmployeeStatus status;
    private LocalDateTime createdAt;
}
