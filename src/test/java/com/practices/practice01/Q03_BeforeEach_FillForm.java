package com.practices.practice01;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_BeforeEach_FillForm {
    /*
     Create chrome driver by using @BeforeEach annotation and WebDriverManager
     Go to url : http://www.gmibank.com/
     Click on 'User Icon'
     Click on 'Register'
     Enter SSN
     Enter First Name
     Enter Last Name
     Enter Address
     Enter Phone Number
     Enter Username
     Enter Email
     Enter New password
     Enter New password confirmation
     Click on Register button
     Assert that user registered
     Close the browser by using @AfterEach annotation
*/

    //     Create chrome driver by using @BeforeEach annotation and WebDriverManager
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Implicit Wait
    }


    @Test
    public void test01() throws InterruptedException {
//        Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

//        Click on 'User Icon'
        WebElement userIcon = driver.findElement(By.id("account-menu"));
        userIcon.click();

//        Click on 'Register'
        driver.findElement(By.linkText("Register")).click();

//        Enter SSN
        driver.findElement(By.id("ssn")).sendKeys("321-99-" + Faker.instance().number().numberBetween(1000, 9999));

//        Enter First Name
        driver.findElement(By.name("firstname")).sendKeys("John");

//        Enter Last Name
        driver.findElement(By.name("lastname")).sendKeys("Doe");

//        Enter Address
        driver.findElement(By.name("address")).sendKeys("New York");

//        Enter Phone Number
        driver.findElement(By.id("mobilephone")).sendKeys("1234567890");

//        Enter Username
        driver.findElement(By.id("username")).sendKeys("johndoe179-180");

//        Enter Email
        driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");

//        Enter New password
        driver.findElement(By.id("firstPassword")).sendKeys("John.123");

//        Enter New password confirmation
        driver.findElement(By.id("secondPassword")).sendKeys("John.123");

//        Click on Register button
        driver.findElement(By.id("register-submit")).click();

//        Assert that user registered
        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.xpath("(//div[@role='alert'])[1]"));
        String alertMessage = alert.getText();
        System.out.println("alertMessage = " + alertMessage);
        assertTrue(alertMessage.contains("Registration saved"));

    }

    //        Close the browser by using @AfterEach annotation
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}