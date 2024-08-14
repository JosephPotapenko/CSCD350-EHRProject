package com.healthconnect;

import com.healthconnect.controller.LoginController;
import com.healthconnect.model.LoginResponse;
import com.healthconnect.service.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private LoginController loginController;

    private LoginResponse mockLoginResponse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockLoginResponse = new LoginResponse("USER", 1L);
    }

    @Test
    public void testLogin_Success() {
        // Arrange
        String email = "newuser@ewu.edu";
        String password = "password";
        when(userAccountService.authenticate(email, password)).thenReturn(mockLoginResponse);

        // Act
        ResponseEntity<LoginResponse> response = loginController.login(email, password);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("USER", response.getBody().getRole());
        assertEquals(1L, response.getBody().getUserId());
    }
}
