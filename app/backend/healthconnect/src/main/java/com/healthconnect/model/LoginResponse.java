package com.healthconnect.model;

public class LoginResponse {
    private String role;
    private Long userId;

    // Constructors
    public LoginResponse(String role, Long userId) {
        this.role = role;
        this.userId = userId;
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
