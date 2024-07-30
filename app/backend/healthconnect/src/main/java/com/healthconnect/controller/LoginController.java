package com.healthconnect.controller;

import com.healthconnect.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String role = userAccountService.authenticate(email, password); // Get the user role if authenticated
        if (role != null) {
            return ResponseEntity.ok(role); // Return the role on successful authentication
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

