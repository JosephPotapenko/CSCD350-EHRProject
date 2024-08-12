package com.healthconnect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/krb20/Documents/GitHub/chromedriver-win64/chromedriver.exe");

        // Set up ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); // Run in headless mode if needed
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginForm() {
        driver.get("http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/login_page/login.html");

        WebElement positionSelect = driver.findElement(By.id("position"));
        positionSelect.sendKeys("Patient");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@example.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("wrongpassword");

        WebElement submitButton = driver.findElement(By.cssSelector(".submit-btn"));
        submitButton.click();

        // Replace with actual expected behavior
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
        assertEquals("Invalid credentials", errorMessage.getText());
    }
}
