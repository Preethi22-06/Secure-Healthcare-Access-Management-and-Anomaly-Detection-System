
package com.preethi.securehealthcare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientResourceController {

    @GetMapping("/{email}")
    public String getPatientProfile(
            @PathVariable String email,
            Authentication authentication) {

        String loggedInEmail = authentication.getName();

        if (!loggedInEmail.equalsIgnoreCase(email)) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.FORBIDDEN,
                    "You cannot access another patient's profile"
            );
        }

        return "Patient profile access granted for " + loggedInEmail;
    }
}
