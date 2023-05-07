package com.mido.shop.api.dto;

import com.mido.shop.domain.entity.Basket;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {


    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

    private int count;

    private UUID imageId;
}
