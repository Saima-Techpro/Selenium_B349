package com.seleniumproject.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C03_RadioButton {

    WebDriver driver;


    @BeforeEach
    public void setUp(){
        // Common steps
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Implicit wait
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
    }

//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    public void radioButtonTest1() throws InterruptedException {
        // Radio button allow only ONE selection at a time

        // Click on Yellow
        WebElement yellowButton = driver.findElement(By.id("yellow"));
        yellowButton.click();
        Thread.sleep(2000);

        // Assert that yellow is selected
        assertTrue(yellowButton.isSelected());

        // Click on Black
        WebElement blackButton = driver.findElement(By.id("black"));
        blackButton.click();
        Thread.sleep(2000);

        // Assert that black is selected
        assertTrue(blackButton.isSelected());

        // Verify that green button is not clickable
        WebElement greenButton = driver.findElement(By.xpath("//input[@id='green']"));
        greenButton.click();
        Thread.sleep(2000);

        // Assertion
        assertFalse(greenButton.isEnabled());

    }

    @Test
    public void radioButtonTest2() throws InterruptedException {
        // Select your favourite sport

        WebElement footBall = driver.findElement(By.id("football"));
        // Assert if football is visible
        assertTrue(footBall.isDisplayed());
        Thread.sleep(2000);

        // Then select it
        footBall.click();

        // Assert that football is selected
        assertTrue(footBall.isSelected());

    }
}
