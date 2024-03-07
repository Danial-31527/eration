package com.example.demo.service;

import com.example.demo.entity.Barber;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> allBarbers(){
        return customerRepository.findAll();
    }
    public void addBarber(Customer barber){
        customerRepository.save(barber);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}