package com.seleniumproject.day03;

import org.junit.jupiter.api.*;

public class C01_JunitAnnotations {
    /*
    @Test : To declare test methods

    @BeforeAll: The method declared with this annotation will be executed ONCE before ALL test cases
    @AfterAll: The method declared with this annotation will be executed ONCE after ALL test cases

    @BeforeEach: The method declared with this annotation will be executed before EACH test case
    @AfterEach: The method declared with this annotation will be executed after EACH test case


     */
    @BeforeAll
    public static void preCondition(){
        System.out.println("Getting things ready!!!");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Shutting down the system!");
    }

    @BeforeEach
    public void setMethodCondition(){
        System.out.println("Setup before each method....");
    }

    @AfterEach
    public void cleaningMethods(){
        System.out.println("Cleaning up method condition...");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }

    @Test
    public void test04(){
        System.out.println("Test 04");
    }









}
