package com.uc.ms_security.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            nullable = false,
            unique = true,
            length = 150
    )
    private String email;

    @Column(
            nullable = false
    )
    private String password;

    // esto hace que la relacion de uno a uno de las dos entidades sea de manera bidireccional
    @OneToOne(
            mappedBy = "user", // variable asociada en el perfil
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY //lazy:solamente cuando yo se lo pido, eager: cuando cargo el usuario, cargo el perfil (siempre)
    )
    private Profile profile;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Session> sessions = new ArrayList<>();
}
