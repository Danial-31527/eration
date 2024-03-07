package com.example.demo.repository;

import com.example.demo.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
    public Barber getBarberById(Long id);
}
