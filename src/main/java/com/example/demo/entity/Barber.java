package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barbers")
public class Barber {
    @Id
    @SequenceGenerator(name = "barber_id_sequence", sequenceName = "barber_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barber_id_sequence")
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customerList = new ArrayList<>();
}
