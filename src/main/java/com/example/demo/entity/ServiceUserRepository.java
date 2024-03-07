package com.example.demo.entity;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceUserRepository extends JpaRepository<ServiceUser, Long> {
    Optional<ServiceUser> findByUsername(String username);
}
