package com.seleniumproject.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C03_Locators {


//    When user goes to :
//    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    And enter username
//    And enter password
//    And click on submit button
//    Then verify the login is successful
//    Then logout the application
//    Then verify the logout is successful

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        // 1. Create driver object
        driver = new ChromeDriver();

        // 2. Maximise the window
        driver.manage().window().maximize();
    }
    @Test
    public void loginTest() throws InterruptedException {

        // 3. Go the given web page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000); // Hard wait

        // 4. Enter userName
        // First locate the element
        WebElement userNameInput = driver.findElement(By.name("username"));
        Thread.sleep(4000);
        // Now send the username
        userNameInput.sendKeys("Admin");

        // 5. Enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");

        // 6. Click on Login button
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        // 7. verify the login is successful
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("dashboard"));

        //8. logout the application
        // First click on dropdown to see the logout option
        WebElement dropdown = driver.findElement(By.className("oxd-userdropdown"));
        dropdown.click();
        Thread.sleep(2000);

        // Now click on logout option
        WebElement logoutOption = driver.findElement(By.linkText("Logout"));
        logoutOption.click();

        // 9.verify the logout is successful
        assertTrue(driver.getCurrentUrl().contains("login"));


    }

    @AfterEach
    public void tearDown(){
        driver.close();
    }

}
