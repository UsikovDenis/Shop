package com.mido.shop.api.dto;

import com.mido.shop.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class BasketDto {

    private BigDecimal totalPrice;

    private List<ProductDto> products;
}
