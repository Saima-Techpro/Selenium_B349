package com.seleniumproject.day04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class C01_Locators {
    /*

    Junit 5 Annotations:
    @BeforeAll -> runs ONCE before all tests in a class
    @AfterAll -> runs ONCE after all tests in a class
    @BeforeEach -> runs ONCE before EACH test in a class
    @AfterEach -> runs ONCE after EACH test in a class
    @Test -> the most used annotation; used to create a Test method
    @disable -> used to ignore a test (@ignore in Junit 4)

    Junit Assertions:
    Assertions are when we check expected results are exactly like actual results
    There are two major types of assertions for testing
    1. Hard assertion - when the program stops running (codes don't execute) immediately wherever the assertions fails
    2. Soft assertion - we will learn later

    examples: assertEquals(), assertTrue(), assertFalse() etc.

    Locators:
    - Almost every application is using web browser these days.
    - Every web browser is made up of a collection of webElements.
    Web elements: button, search box, text box, headers, footers, title, urls, images, videos etc.
    All these web elements are created using HTML tags like input, anchor, div, img, section, video tags etc.

    In Selenium, we use driver object to find these elements and then perform some actions on them.
    To find these elements, we have to steps:
            1. Locate the element (using locators)
            2. Perform the action
     To locate the elements, Selenium has 8 locators:
     (First three are based on attributes)
     1. id
     2. name
     3. className
     4. tagName
     5. linkText (works with anchor tag <a> only)
     6. partialLinkText  (works with anchor tag <a> only)
     7. xpath -> there are multiple ways of writing xpath
     8. css -> there are multiple ways of writing xpath


     */
    WebDriver driver;

    @BeforeAll
    public static void preCondition(){
        System.out.println("Getting things ready!!!");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Shutting down the system!");
    }

    @BeforeEach
    public void setUp(){
        // Common steps that are needed before each test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Thread.sleep(3000); // Hard wait - not recommended - forces the driver to wait EVEN IF IT IS NOT NEEDED

        // Dynamic wait - RECOMMENDED - because only waits IF IT IS NEEDED otherwise, it lets the driver move on
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    public void tearDown(){
        // Common steps that are needed after each test
        driver.quit();

    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        String actualAmazonTitle = driver.getTitle();
        String expectedAmazonTile = "Amazon.com. Spend less. Smile more.";
        assertEquals(expectedAmazonTile , actualAmazonTitle);
    }

    @Test @Disabled
    public void test02(){
        driver.get("https://www.facebook.com");
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("facebook"));

    }

    @Test
    public void test03(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("login"));

        // NOTE: We have added implicit wait in setUp() method which will make driver wait up to 15
        // seconds if required and wherever required

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("Admin"); // sendKeys() is a method used to write something on an input yag

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        // We can use 'button' as tagName here as this page has only ONE button
        loginButton.click();

        // Assert that login is successful
        WebElement header = driver.findElement(By.xpath("//h6"));

        assertTrue(header.getText().contains("Dashboard"));

        // Logout and assert logout is successful
        WebElement dropdown = driver.findElement(By.className("oxd-userdropdown"));
        dropdown.click();

        WebElement logoutOption = driver.findElement(By.linkText("Logout"));
        logoutOption.click();

        WebElement homepageHeader = driver.findElement(By.xpath("//h5"));
        String actualHeader = homepageHeader.getText();

        assertEquals("Login", actualHeader);



    }

    @Test
    public void test04(){
        driver.get("https://www.google.com");
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("GOOGLE"));
    }



}
