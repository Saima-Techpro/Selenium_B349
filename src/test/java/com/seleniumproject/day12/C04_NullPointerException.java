package com.seleniumproject.day12;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NullPointerException {
    // NOTE: DO NOT EXTEND TO TestBase class

    WebDriver driver;
    Integer number;
    String str;

    @Test
    public void nullPointerExceptionTest1 (){
        // driver = new ChromeDriver(); // here we are instantiating the driver

        driver.get("https://www.techproeducation.com"); // NullPointerException

        // NullPointerException: Because a variable called driver is created at the class level, but it is not instantiated.
        // So pointer does not show any value and throws NullPointerException

    }

    @Test
    public void nullPointerExceptionTest2 (){
        System.out.println(number + 1); // NullPointerException: because number variable was never initiated /instantiated.
    }

    @Test
    public void nullPointerExceptionTest3 (){
        System.out.println(str.substring(0)); // NullPointerException
    }
}
