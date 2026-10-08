package com.preethi.securehealthcare.controller;

import com.preethi.securehealthcare.dto.LoginRequest;
import com.preethi.securehealthcare.dto.RegistrationRequest;
import com.preethi.securehealthcare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.preethi.securehealthcare.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

   public AuthController(UserService userService,
                      JwtService jwtService) {
    this.userService = userService;
    this.jwtService = jwtService;
}

    @PostMapping("/login")
public ResponseEntity<String> login(
        @RequestBody LoginRequest request) {

    var user = userService.authenticateUser(request);

    String token = jwtService.generateToken(user.getEmail());
    

    return ResponseEntity.ok(token);
}
}