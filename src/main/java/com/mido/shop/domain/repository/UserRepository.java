package com.mido.shop.domain.repository;

import com.mido.shop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
}
