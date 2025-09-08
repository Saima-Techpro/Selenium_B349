package com.seleniumproject.day05;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;

public class C05_TestBaseDemo extends TestBase {

    @Test
    public void test1(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }




}
