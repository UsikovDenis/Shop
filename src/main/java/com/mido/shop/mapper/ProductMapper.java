package com.mido.shop.mapper;


import com.mido.shop.api.dto.ProductDto;
import com.mido.shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

  @Mapping(target = "imageId", source = "image.id")
    ProductDto toDto(Product product);


    Product toEntity(ProductDto productDto);
}
