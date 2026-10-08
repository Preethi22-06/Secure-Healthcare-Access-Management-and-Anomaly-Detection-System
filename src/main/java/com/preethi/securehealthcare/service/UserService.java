package com.preethi.securehealthcare.service;

import com.preethi.securehealthcare.dto.RegistrationRequest;
import com.preethi.securehealthcare.entity.Role;
import com.preethi.securehealthcare.entity.User;
import com.preethi.securehealthcare.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegistrationRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        String hashedPassword =
                passwordEncoder.encode(request.getPassword());

        user.setPassword(hashedPassword);

       user.setRole(Role.PATIENT);

        return userRepository.save(user);
        
    }
}