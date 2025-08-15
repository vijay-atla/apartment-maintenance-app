package com.apartment.maintenance.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apartment.maintenance.auth.dto.LoginRequestDTO;
import com.apartment.maintenance.auth.dto.RegisterRequestDTO;
import com.apartment.maintenance.user.entity.User;
import com.apartment.maintenance.user.repository.UserRepository;
import com.apartment.maintenance.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User registerAdmin(RegisterRequestDTO request) {
        // Check if user already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }

        // Create new user entity
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));  // Hash password
        user.setRole("RESIDENCY_ADMIN");

        // Save to DB
        return userRepository.save(user);
    }

    @Override
    public User loginResidencyAdmin(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (!"RESIDENCY_ADMIN".equalsIgnoreCase(user.getRole())) {
            throw new RuntimeException("Unauthorized role");
        }

        return user;
    }

}
