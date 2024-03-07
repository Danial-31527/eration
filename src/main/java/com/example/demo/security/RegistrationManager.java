package com.example.demo.security;

import com.example.demo.entity.ServiceUser;
import com.example.demo.entity.ServiceUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationManager {
    private final PasswordEncoder passwordEncoder;
    private final ServiceUserRepository serviceUserRepository;

    @Transactional
    public void add(ServiceUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        serviceUserRepository.save(user);
    }
}
