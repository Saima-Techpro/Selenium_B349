package com.seleniumproject.day13;

import com.utils.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class C03_Log4J extends TestBase {

    // Create Logger Object
    private static Logger logger = LogManager.getLogger(C03_Log4J.class.getName());


    @Test
    public void log4JTest1(){
        System.out.println("Normal printing .... ");

        logger.fatal("Fatal log....!");
        logger.error("Error log....");
        logger.warn("Warning log...");
        logger.info("Info log!");
        logger.debug("Debug log!");
        logger.trace("Trace log!");

    }


    @Test
    public void log4JTest2(){
        driver.get("https://www.google.com");
        logger.fatal("Test failed because there's no such element");
        WebElement searchBox = driver.findElement(By.name("wrong locator"));
        searchBox.sendKeys("Tea pot");

    }


}
