package com.seleniumproject.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_FirefoxTest {
    public static void main(String[] args) {

        // NOTE: From now onwards we will use only the latest method of creating the driver object
        // which is called Selenium driver

        WebDriver driver = new FirefoxDriver();

        // Maximise the window
        driver.manage().window().maximize();

        // Open the amazon page
        driver.get("https://www.amazon.com");

        // Close the browser
        driver.quit(); // it closes the current window opened by the driver


    }
}
