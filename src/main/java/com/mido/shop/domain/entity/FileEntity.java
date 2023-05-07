package com.mido.shop.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "file_entity")
public class FileEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Lob
    private byte[] data;
}
