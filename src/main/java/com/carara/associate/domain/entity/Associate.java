package com.carara.associate.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "associate")
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cpf;
    private String email;

}