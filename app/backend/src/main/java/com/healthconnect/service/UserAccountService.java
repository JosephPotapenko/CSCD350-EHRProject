package com.healthconnect.service;

import com.healthconnect.model.UserAccount;
import com.healthconnect.repository.UserAccountRepository;
import com.healthconnect.model.LoginResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginResponse authenticate(String email, String password) {
        UserAccount userAccount = userAccountRepository.findByEmail(email);
        if (userAccount != null && passwordEncoder.matches(password, userAccount.getPassword())) {
            return new LoginResponse(userAccount.getRole(), userAccount.getUserId()); // Return role and user ID
        }
        return null; // Return null if authentication fails
    }

    /*public String authenticate(String email, String password) {
        UserAccount userAccount = userAccountRepository.findByEmail(email);
        if (userAccount != null && passwordEncoder.matches(password, userAccount.getPassword())) {
            return userAccount.getRole(); // Return the role of the authenticated user
        }
        return null; // Return null if authentication fails
    }
*/
    public void registerNewUser(String username, String email, String rawPassword, String role) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        UserAccount newUser = new UserAccount(username, encodedPassword, role, email);
        userAccountRepository.save(newUser);
    }
    @PostConstruct
    public void hashExistingPasswords() {
        List<UserAccount> users = userAccountRepository.findAll();
        for (UserAccount user : users) {
            if (!user.getPassword().startsWith("$2a$")) { // Check if the password is already hashed
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userAccountRepository.save(user);
            }
        }
    }
}