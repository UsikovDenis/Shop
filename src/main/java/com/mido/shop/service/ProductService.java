package com.mido.shop.service;


import com.mido.shop.api.dto.ProductDto;
import com.mido.shop.domain.entity.Product;
import com.mido.shop.domain.repository.ProductRepository;
import com.mido.shop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDto getOne(UUID id) {
        return productMapper.toDto(findOne(id));
    }

    @Transactional
    public ProductDto saveOrUpdate(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Transactional
    public void delete(UUID id) {
        productRepository.delete(findOne(id));
    }


    private Product findOne(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not id"));
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> getPageProduct(final Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper::toDto);
    }


}
