package com.comparsas.unpapo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "localizacao")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "pais")
    private String country;

    public boolean isValid() {
        return this.latitude != null && this.longitude != null && this.city != null
                && this.state != null && this.country != null;
    }
}
