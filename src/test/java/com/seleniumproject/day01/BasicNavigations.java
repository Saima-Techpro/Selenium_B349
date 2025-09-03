package com.seleniumproject.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigations {

    public static void main(String[] args) {
        // Locate the Chrome Driver (NOT NEEDED IN LATEST VERSIONS)
//        System.setProperty("webdriver.chrome.driver" , "D:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // absolute path for Windows
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");  // Content root path for Windows
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");  // Content root path for Mac

        // Initialise the driver object
        // WebDriver driver = new FirefoxDriver();
       // WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://www.google.com/");

        // Open another website
        driver.navigate().to("https://www.facebook.com");

        // Go back to google page
        driver.navigate().back();

        // Go to Amazon
        driver.navigate().to("https://www.amazon.com");

        // Hard wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Refresh the page
        driver.navigate().refresh();

        // Hard wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Close the driver
        driver.close(); // closes the current browser



    }

}
