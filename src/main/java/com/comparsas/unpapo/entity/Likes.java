package com.comparsas.unpapo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "curtidas")
public class Likes {

    public Likes(Date date, User userLiked, User userLiker) {
        this.date = date;
        this.userLiked = userLiked;
        this.userLiker = userLiker;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "usuario_curtiu")
    private User userLiker;

    @OneToOne
    @JoinColumn(name = "usuario_curtido")
    private User userLiked;

    @Column(name = "data_curtida")
    private Date date;

}
