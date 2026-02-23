package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "duty_assignments")
@Setter
public class DutyAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private DutyShift shift;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private DutySlot slot;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String status;

    private LocalDateTime assignedAt = LocalDateTime.now();
}
