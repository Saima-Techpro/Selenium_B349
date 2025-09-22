package com.seleniumproject.day13;

import com.utils.TestBase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.utils.LoggerUtils.*;



public class C03_Log4J_WithReusableMethods extends TestBase {

    // No need to create Logger Object
    // Because we are using Reusable Methods from LoggerUtils class
    // Logger object is already created in LoggerUtils class


    @Test
    public void log4JTest1(){
        System.out.println("Normal printing .... ");

        fatal("Fatal log....!");
        error("Error log....");
        warn("Warning log...");
        info("Info log!");
        debug("Debug log!");
        trace("Trace log!");

    }


    @Test
    public void log4JTest2(){
        driver.get("https://www.google.com");
        fatal("Test failed because there's no such element");
        WebElement searchBox = driver.findElement(By.name("wrong locator"));
        searchBox.sendKeys("Tea pot");

    }


}
