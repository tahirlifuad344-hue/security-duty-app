package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "duty_slots")
@Setter
public class DutySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private DutyTemplate template;

    private String code;

    private String displayName;

    private Integer positionNo;

    private String requiredRoleCode;

    private Integer priority;
}
