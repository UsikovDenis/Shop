package com.mido.shop.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CommentDto {

    private UUID id;

    private String userName;

    private String message;

    @JsonIgnore
    private UUID userId;

    @JsonIgnore
    private UUID productId;

}
