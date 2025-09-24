package com.practices.practice02;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q03_LastElementPrice extends TestBase {

      /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  And
    Order products by "Price (low to high)"
  Then
    Assert that first product costs $7.99 , last product costs $49.99
*/

    @Test
    public void lastElementPrice(){

        driver.get("https://www.saucedemo.com/");

        // Login

        // Username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        waitFor(1);

        // Password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        waitFor(1);

        // Click on Login Button
        driver.findElement(By.id("login-button")).click();
        waitFor(1);

        // Locate the dropdown
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);

        // Sort products by "Price (low to high)"
        select.selectByVisibleText("Price (low to high)");

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        String firstPrice = prices.get(0).getText();
        String lastPrice = prices.get(prices.size() - 1).getText();

        assertEquals("$7.99", firstPrice);
        assertEquals("$49.99", lastPrice);

    }

}
