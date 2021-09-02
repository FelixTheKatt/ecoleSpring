package com.example.ecole.model.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserEcole")
@Table(name = "user_ecole")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    private String email;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private List<UserCours> userCoursList;


}
