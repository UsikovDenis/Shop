package com.mido.shop.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany()
    private List<Product> products;

    @PrePersist
    @PreUpdate
    private void update(){
       totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
