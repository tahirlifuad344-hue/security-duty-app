
package com.example.security.dto;

import com.example.security.entity.EmployeeStatus;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    private String code;
    private String fullName;
    private EmployeeStatus status;
}
