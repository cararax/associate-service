package com.carara.associate.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "associate")
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //    @CPF
    @Column(name = "cpf", nullable = false, unique = true)
    @NotBlank(message = "CPF is mandatory")
    @Size(min = 11, max = 14, message = "CPF must have 11 digits")
    private String cpf;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", nullable = false)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Associate associate = (Associate) o;
        return id != null && Objects.equals(id, associate.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}