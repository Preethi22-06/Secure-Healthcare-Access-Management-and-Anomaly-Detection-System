package com.preethi.securehealthcare.service;

import com.preethi.securehealthcare.dto.LoginRequest;
import com.preethi.securehealthcare.dto.RegistrationRequest;
import com.preethi.securehealthcare.entity.Role;
import com.preethi.securehealthcare.entity.User;
import com.preethi.securehealthcare.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
    public User authenticateUser(LoginRequest request) {

    Optional<User> userOptional =
            userRepository.findByEmail(request.getEmail());

    if (userOptional.isEmpty()) {
        throw new RuntimeException("Invalid email or password");
    }

    User user = userOptional.get();

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        throw new RuntimeException("Invalid email or password");
    }

    return user;
}
}