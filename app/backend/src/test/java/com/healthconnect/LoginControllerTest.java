package com.healthconnect;

import com.healthconnect.controller.LoginController;
import com.healthconnect.model.LoginResponse;
import com.healthconnect.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

//+

    @Test
    public void testLogin() throws Exception {
        // Arrange: Mock the service to return null (authentication failure)
        Mockito.when(userAccountService.authenticate("test@example.com", "wrongpassword"))
                .thenReturn(null);

        // Act & Assert: Perform the login request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .param("option value", "patient")
                        .param("email", "test@example.com")
                        .param("password", "wrongpassword")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isForbidden());
    }
}
