package com.seleniumproject.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02_CheckBox {

    WebDriver driver;


    @BeforeEach
    public void setUp(){
        // Common steps
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Implicit wait
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkBoxTest(){
        // Locate the checkboxes
        WebElement checkBox1 = driver.findElement(By.id("box1"));
        WebElement checkBox2 = driver.findElement(By.id("box2"));

        // Click on checkbox 1 if it's not already checked
        if (! checkBox1.isSelected()){
            checkBox1.click();
        }

        // Uncheck checkbox 2

        if (checkBox2.isSelected()){
            checkBox2.click();
        }

        // Verification
        assertTrue(checkBox1.isSelected());
        assertFalse(checkBox2.isSelected());

    }

}
