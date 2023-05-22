package com.mido.shop.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file_entity")
public class FileEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private String directory;

    @Lob
    private byte[] data;

    @PrePersist
    private void create() {
        createDate = LocalDateTime.now();
    }

    public String getAbsolutePath() {
        return String.format("%s/%s", directory, fileName);
    }

}
