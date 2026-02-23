package com.example.security.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "shiftDate")
})
public class ShiftDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;

    @OneToMany(mappedBy = "shiftDay", cascade = CascadeType.ALL)
    private List<ShiftAssignment> assignments;

    public void setShiftDate(LocalDate date) {

    }
}

