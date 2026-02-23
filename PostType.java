package com.example.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter

@Entity
@Table
public enum PostType {
    SUPERVISOR,
    POST1,
    POST2,
    POST3,
    POST4;
    @Id
    private Long id1;
    @Id
    private Long id;
}


    //TODO [Reverse Engineering] generate columns from DB
