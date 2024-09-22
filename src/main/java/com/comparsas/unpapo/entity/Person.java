package com.comparsas.unpapo.entity;

import com.comparsas.unpapo.utils.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private Long birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "genero")
    private Gender gender;

}
