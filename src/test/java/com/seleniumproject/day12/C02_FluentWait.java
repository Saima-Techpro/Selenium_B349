package com.seleniumproject.day12;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class C02_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

        // FLUENT WAIT
        // Step 1: Create Fluent Wait object
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(15)). // total wait
                pollingEvery(Duration.ofSeconds(2)).  // how often the element will be checked
                withMessage("Ignoring No Such Element Exception"). // OPTIONAL
                ignoring(NoSuchElementException.class); // OPTIONAL

        // Step 2: Use this object with the appropriate methods to handle the SYNCHRONISATION issue.
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        System.out.println("successMessage = " + successMessage.getText());

        // Verify the success message is visible

        assertEquals("Hello World!", successMessage.getText());


    }

    @Test
    public void fluentWaitWithReusable(){
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");
        // Click on Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

        // Find element using Reusable method from TestBase =>  waitForVisibility()
        WebElement successMessage = fluentWait("//div[@id='finish']//h4", 15, 3);

        // Verify the success message is visible
        assertEquals("Hello World!", successMessage.getText());
    }
}
