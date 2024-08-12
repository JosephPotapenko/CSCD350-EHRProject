package com.healthconnect.controller;

import com.healthconnect.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/register")
    public void registerUser(@RequestParam String username, //unused really Go check out the register.html
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String role) {
        userAccountService.registerNewUser(username, email, password, role);
    }
}
