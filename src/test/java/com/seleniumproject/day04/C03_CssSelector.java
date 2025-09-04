package com.seleniumproject.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C03_CssSelector {

    /*
    csSelectors are shorter version of XPATH

    template: tagName[attribute='value of the attribute']
              tagName#value of id => # stands for id
              tagName.value of the class => . stands class
              example: input.oxd-input

     */


    WebDriver driver;
    @BeforeEach
    public void setUp(){
        // Common steps that are needed before each test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Thread.sleep(3000); // Hard wait - not recommended - forces the driver to wait EVEN IF IT IS NOT NEEDED

        // Dynamic wait - RECOMMENDED - because only waits IF IT IS NEEDED otherwise, it lets the driver move on
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    public void tearDown(){
        // Common steps that are needed after each test
        driver.quit();

    }

    @Test
    public void loginTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("login"));

        // NOTE: We have added implicit wait in setUp() method which will make driver wait up to 15
        // seconds if required and wherever required

        WebElement usernameInput = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        usernameInput.sendKeys("Admin"); // sendKeys() is a method used to write something on an input yag

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        passwordInput.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        // We can use 'button' as tagName here as this page has only ONE button
        loginButton.click();

        // Assert that login is successful
        WebElement header = driver.findElement(By.cssSelector("h6"));

        assertTrue(header.getText().contains("Dashboard"));

        // Logout and assert logout is successful
        WebElement dropdown = driver.findElement(By.cssSelector(".oxd-userdropdown"));
        dropdown.click();

        // (//a[@role='menuitem'])[4]  OR (//a)[18] OR use linkText() or partialLinkText()
        WebElement logoutOption = driver.findElement(By.xpath("(//a[@role='menuitem'])[4]"));
        logoutOption.click();

        WebElement homepageHeader = driver.findElement(By.cssSelector("h5"));
        String actualHeader = homepageHeader.getText();

        assertEquals("Login", actualHeader);


    }
}
