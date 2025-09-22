package com.homework;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class HW05 extends TestBase{

    /* HW TASK:
        - Go to https://the-internet.herokuapp.com/dynamic_controls
        - Click enable Button
        - And verify the message is equal to "It's enabled!"
        - And verify the textbox is enabled (I can type in the box)
         - click on disable button*/


    @Test
    public void dynamicControlsTest() {


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Enable button
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        // Wait for message
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // Verify message
        if (message.getText().equals("It's enabled!")) {
            System.out.println("Message verified: It's enabled!");
        } else {
            System.out.println("Message verification failed!");
        }

        // Verify textbox is enabled
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        if (textbox.isEnabled()) {
            System.out.println("Textbox is enabled, you can type.");
        } else {
            System.out.println("Textbox is not enabled!");
        }
    }
}
