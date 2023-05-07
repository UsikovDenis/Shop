package com.mido.shop.api.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
public class UserDto {


    private UUID id;

    private  String name;

    private LocalDateTime birthDate;

    private  String email;

    private  String backed;

    private  String login;

    private  String password;

    private  String phone;

    private  String adress;






}
