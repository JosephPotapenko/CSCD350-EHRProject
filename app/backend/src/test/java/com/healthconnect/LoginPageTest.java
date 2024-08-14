package com.healthconnect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
        //System.setProperty("webdriver.http.factory", "jdk-http-client");

        // Initialize the ChromeDriver using the class-level 'driver' variable
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*");
        chromeOption.setPageLoadStrategy(PageLoadStrategy.NONE);
        //WebDriver driver = new ChromeDriver();

        // Logging
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        chromeOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOption);
        // Navigate to your login page
        driver.get("http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/login_page/login.html"/*"https://www.google.com"*/);
    }

    @Test
    public void testLoginPage() {
        // Check the redirected URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:63342/cs350-summer2024-project-dev-oops/app/frontend/login_page/login.html", currentUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
