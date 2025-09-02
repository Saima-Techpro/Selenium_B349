package com.seleniumproject.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerClass {
    public static void main(String[] args) {

//        1st way of setting up the driver:
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

//        2nd way of setting up the driver:
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();

        // NOTE: From Selenium 4 onwards, we do NOT need the 1st way or 2nd wat at all.
        // WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");


    }
}
