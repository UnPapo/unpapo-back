package com.comparsas.unpapo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "curtida_id")
    private Likes like;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "data_match")
    private Date dataMatch;

}