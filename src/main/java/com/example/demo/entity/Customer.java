package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @SequenceGenerator(name = "barber_id_sequence", sequenceName = "barber_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barber_id_sequence")
    private Long id;
    private String customerName;
    private String phoneNumber;
    @ManyToOne
    private Barber barber;
}
