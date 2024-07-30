package com.healthconnect.service;

import com.healthconnect.model.UserAccount;
import com.healthconnect.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public String authenticate(String email, String password) {
        UserAccount userAccount = userAccountRepository.findByEmail(email);
        if (userAccount != null && userAccount.getPassword().equals(password)) {
            return userAccount.getRole(); // Return the role of the authenticated user
        }
        return null; // Return null if authentication fails
    }
}
