package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "duty_changes")
@Setter
public class DutyChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DutyShift shift;

    @ManyToOne
    private DutySlot slot;

    @ManyToOne
    @JoinColumn(name = "old_assignment_id")
    private DutyAssignment oldAssignment;

    @ManyToOne
    @JoinColumn(name = "new_assignment_id")
    private DutyAssignment newAssignment;

    private LocalDateTime changedAt = LocalDateTime.now();

    private String reason;
    private String note;
}
