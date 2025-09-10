package com.seleniumproject.day07;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class C02_Authentication extends TestBase {

    @Test
    public void authTest(){
        /*
        username: admin
        password: admin
        url : https://the-internet.herokuapp.com/basic_auth
        Special url for authentication
        https://username:password@the rest of the url
         */

        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Assertion that login is successful
        WebElement messageElement = driver.findElement(By.xpath("//p"));
        String messageText =  messageElement.getText();

        assertTrue(messageText.contains("Congratulations"));

        // Or

        assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


    }

}
