package com.example.ecole.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserInterro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Boolean present;

    private Integer points;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserCours userCours;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Interro interro;
}
