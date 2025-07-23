package com.apartment.maintenance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.maintenance.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
