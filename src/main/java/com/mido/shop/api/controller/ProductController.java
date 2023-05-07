package com.mido.shop.api.controller;


import com.mido.shop.api.dto.ProductDto;
import com.mido.shop.service.CommentService;
import com.mido.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CommentService commentService;

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable UUID id) {
        return productService.getOne(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        productDto.setId(null);
        return productService.saveOrUpdate(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable UUID id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        return productService.saveOrUpdate(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }

}
