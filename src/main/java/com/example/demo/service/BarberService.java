package com.example.demo.service;

import com.example.demo.entity.Barber;
import com.example.demo.entity.Customer;
import com.example.demo.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BarberService {
    private final BarberRepository barberRepository;
    private final CustomerService customerService;
    public List<Barber> allBarbers(){
        return barberRepository.findAll();
    }
    public void addBarber(Barber barber){
        barberRepository.save(barber);
    }
    public void deleteBarber(Long id){
        barberRepository.deleteById(id);
    }
    public Barber findBarberById(Long id){
        return barberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public Barber getBarberById(Long id){
        return barberRepository.getBarberById(id);
    }
    public void updateBarber(Barber barber) {
        if (barber.getId() != null) {
            barberRepository.save(barber);
        }
    }
public Barber addCustomerToBarber(Long barberId, Customer newCustomer) {
    Barber barber = barberRepository.findById(barberId).orElseThrow(NoSuchElementException::new);
    if (barber != null) {
        newCustomer.setBarber(barber);
        customerService.addBarber(newCustomer);
        barber.getCustomerList().add(newCustomer);
        barberRepository.save(barber);
        }
    return barber;
    }
    public void deleteCustomer(Long barberId, Long customerId) {
        Barber barber = barberRepository.findById(barberId).orElse(null);
        if (barber != null) {
            Customer customer = customerService.findCustomerById(customerId);
            if (customer != null) {
                barber.getCustomerList().remove(customer);
                barberRepository.save(barber);
                customerService.deleteCustomer(customer.getId());
            }
        }
    }
}
