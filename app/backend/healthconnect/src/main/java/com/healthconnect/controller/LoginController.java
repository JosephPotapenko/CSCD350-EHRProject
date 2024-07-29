package com.healthconnect.controller;

import com.healthconnect.model.UserAccount;
import com.healthconnect.service.UserAccountService; // Assume this service handles authentication
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
        boolean authenticated = userAccountService.authenticate(email, password); // Implement this method
        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
