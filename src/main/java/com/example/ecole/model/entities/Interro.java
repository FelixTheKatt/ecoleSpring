package com.example.ecole.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Interro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Cours cours;
}
