package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ShiftAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "post_type_ıd")
    private PostType postType;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private ShiftDay shiftDay;

    public Employee getEmployee() {
        return null;
    }

    public void setEmployee(Employee e) {

    }

    public void setShiftDay(ShiftDay day) {

    }
}
