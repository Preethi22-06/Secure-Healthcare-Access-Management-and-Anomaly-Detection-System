package com.preethi.securehealthcare.controller;

import com.preethi.securehealthcare.dto.RegistrationRequest;
import com.preethi.securehealthcare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegistrationRequest request) {

        userService.registerUser(request);

        return ResponseEntity.ok("User registered successfully");
    }
}