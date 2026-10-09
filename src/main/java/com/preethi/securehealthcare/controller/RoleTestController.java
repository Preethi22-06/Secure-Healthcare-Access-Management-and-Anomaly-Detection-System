
package com.preethi.securehealthcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTestController {

    @GetMapping("/api/patient/test")
    public String patientTest() {
        return "Patient access granted!";
    }

    @GetMapping("/api/doctor/test")
    public String doctorTest() {
        return "Doctor access granted!";
    }

    @GetMapping("/api/admin/test")
    public String adminTest() {
        return "Admin access granted!";
    }
}
