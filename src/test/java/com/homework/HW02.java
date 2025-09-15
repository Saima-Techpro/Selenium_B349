package com.homework;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW02 extends TestBase {
    // HW02: Dropdown Task
    // Go to https://testcenter.techproeducation.com/index.php?page=dropdown
    // Select your date of birth
    // Verify your date of birth is selected

    @Test
    public void calculate (){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculate = driver.findElement(By.id("calculatetest"));
        calculate.click();

        driver.findElement(By.id("number1")).sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("6");
        WebElement calculation = driver.findElement(By.id("calculate"));
        calculation.click();

        WebElement result = driver.findElement(By.id("answer"));
        String resultText = result.getText();
        System.out.println(resultText);
        String expected = "11";

        assertEquals(resultText,expected);
        }

}
