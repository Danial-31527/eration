package com.example.demo.controller;

import com.example.demo.entity.Barber;
import com.example.demo.entity.Customer;
import com.example.demo.service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;
    @GetMapping("/")
    public String allBarbers(Model model) {
        List<Barber> barberList = barberService.allBarbers();
        model.addAttribute("barbers", barberList);
        return "all-barbers";
        /**
         * all-barbers.html
         * */
    }
    @GetMapping("/addNewBarber")
    public String addNewBarber(Model model){
        Barber barber = new Barber();
        model.addAttribute("barber", barber);
        return "add-barber";
    }
    @PostMapping("/saveBarber")
    public String createNewBarber(@ModelAttribute("barber")Barber barber){
        barberService.addBarber(barber);
        return "redirect:/barbers/";
    }
    @DeleteMapping("/deleteBarber")
    public String deleteUser(@RequestParam("id") Long id) {
        barberService.deleteBarber(id);
        return "redirect:/barbers/";
    }

    @GetMapping("/editBarber/{id}")
    public String editBarber(@PathVariable Long id, Model model) {
        Barber barber = barberService.getBarberById(id);
        model.addAttribute("barber", barber);
        return "editBarber";
    }

    @PutMapping("/updateBarber")
    public String updateBarber(@ModelAttribute Barber barber) {
        barberService.updateBarber(barber);
        return "redirect:/barbers/";
    }


    @GetMapping("/{id}")
    public String viewBarberPage(@PathVariable Long id, Model model) {
        Barber barber = barberService.getBarberById(id);
        model.addAttribute("barber", barber);
        model.addAttribute("newCustomer", new Customer());
        return "barbers-customers";
    }

    @PostMapping("/{id}/add-customer")
    public String addCustomerToBarber(@PathVariable Long id,
                                      @ModelAttribute("newCustomer") Customer newCustomer) {
        barberService.addCustomerToBarber(id, newCustomer);
        return "redirect:/barbers/" + id;
    }
    @PostMapping("/{barberId}/delete-customer/{customerId}")
    public String deleteCustomer(@PathVariable Long barberId, @PathVariable Long customerId) {
        barberService.deleteCustomer(barberId, customerId);
        return "redirect:/barbers/" + barberId;
    }
}
