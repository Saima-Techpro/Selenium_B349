package com.seleniumproject.day12;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C06_StaleElementException extends TestBase {

    @Test
    public void staleElementExceptionTest(){

        driver.get("https://lms.techproeducation.com/");

        WebElement loginButton  = driver.findElement(By.linkText("Login"));
        System.out.println(loginButton.getText());

        driver.navigate().refresh();
        System.out.println(loginButton.getText()); // StaleElementReferenceException

        // We get StaleElementReferenceException after we refresh the page because the locator is not available anymore
        // Solution : Locate the element AGAIN

        // WebElement loginButton1  = driver.findElement(By.linkText("Login"));
        //  System.out.println(loginButton1.getText());

    }
}
