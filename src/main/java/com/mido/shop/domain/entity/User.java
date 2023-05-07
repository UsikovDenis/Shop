package com.mido.shop.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_Date")
    private LocalDateTime birthDate;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "adress", nullable = false)
    private String adress;

    @OneToOne()
    @JoinColumn(name = "basket_id")
    private  Basket basket;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

}
