package com.example.demo.controller;

import com.example.demo.entity.ServiceUser;
import com.example.demo.security.RegistrationManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    private final RegistrationManager register;
    @GetMapping
    public String getRegPage(){ return "login"; }
    @PostMapping
    public String register(@RequestParam(name = "password") String pass,
                         @RequestParam(name = "username") String username) {
        ServiceUser user = new ServiceUser();
        user.setPassword(pass);
        user.setUsername(username);
        log.info("{}", user);
        register.add(user);
        return "redirect:/login";
    }
}
