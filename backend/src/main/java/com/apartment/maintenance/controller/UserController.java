package com.apartment.maintenance.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.maintenance.dto.LoginRequestDTO;
import com.apartment.maintenance.dto.LoginResponseDTO;
import com.apartment.maintenance.dto.RegisterRequestDTO;
import com.apartment.maintenance.entity.User;
import com.apartment.maintenance.service.interfaces.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend calls (adjust if needed)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequestDTO request) {
        try {
            User createdUser = userService.registerAdmin(request);
            return ResponseEntity.ok(createdUser);  // Return 200 with user object
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", ex.getMessage()));  // Return 400 with error msg
        }
    }

    @PostMapping("/login-admin")
    public ResponseEntity<?> loginResidencyAdmin(@RequestBody LoginRequestDTO request) {
        try {
            User user = userService.loginResidencyAdmin(request);
            LoginResponseDTO response = new LoginResponseDTO(
                "Login successful",
                user.getRole(),
                user.getEmail(),
                user.getFirstName() + " " + user.getLastName()
            );

            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
    }
}
