package com.healthconnect.controller;

import com.healthconnect.model.LoginResponse;
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
    public ResponseEntity<LoginResponse> login(@RequestParam String email, @RequestParam String password) {
        //String role = userAccountService.authenticate(email, password); // Get the user role if authenticated
        LoginResponse loginResponse = userAccountService.authenticate(email, password);
        if (loginResponse != null) {
            return ResponseEntity.ok(loginResponse); // Return the role on successful authentication
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
    /*@PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String role) {
        userAccountService.registerNewUser(username, email, password, role);
        return ResponseEntity.ok("User registered successfully");
    }*/
}

