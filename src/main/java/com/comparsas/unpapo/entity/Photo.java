package com.comparsas.unpapo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "foto")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private User user;
}
