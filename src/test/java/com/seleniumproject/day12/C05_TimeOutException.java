package com.seleniumproject.day12;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class C05_TimeOutException extends TestBase {

    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com ");

        // Locate an element using Explicit wait
        waitForVisibility(By.id("wrong-id"), 10); // TimeoutException

        // We get TimeoutException because Explicit wait couldn't find any element with this id
        // It kept trying for 10 seconds, when wait time is over and element is still not visible,
        // TimeoutException is thrown.


    }
}
