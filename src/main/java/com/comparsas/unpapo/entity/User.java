package com.comparsas.unpapo.entity;

import com.comparsas.unpapo.utils.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "senha")
    private String password;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "data_nascimento")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "biografia")
    private String biography;

    @Column(name = "workplace")
    private String profissao;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Photo> photos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_id")
    private Location location;

}
