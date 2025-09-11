package com.homework;

import com.github.javafaker.Faker;
import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HW01 extends TestBase {
    // HW01: Facebook Registration Task
    // Go to facebook home page
    // Click on Create new account
    // Fill up the form using faker class
    // Click on Sign Up button
    // Verify that you landed on the next page

    @Test
    public void accountSignUp() throws InterruptedException {
        //1: Click on "Create new account"

        driver.get("https://www.facebook.com"); // now you can open the page

        WebElement createAccountButton = driver.findElement(By.linkText("Create new account"));
        createAccountButton.click();
        Thread.sleep(4000);


        // Step 2: Generate fake data
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();



        // Step 3: Fill out the form
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);

        // Fill DOB
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Jun");

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("12");

        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("1990");

        // Select gender/Select birthdate/
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        Thread.sleep(4000);

        //Email
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        Thread.sleep(1000); // Wait for confirmation field
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);

        // Step 6: Click on Sign Up
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);

        // Verify sign up is not successful
        assertFalse(driver.findElement(By.xpath("//h2")).getText().contains("Enter the code from your email"));


    }

    @Test
    public void registerNewAccount() throws InterruptedException {

        Faker faker = new Faker();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        // Click on "Create New Account"
        WebElement createAccountButton = driver.findElement(By.linkText(("Create new account")));
        createAccountButton.click();

        Thread.sleep(1000); // Wait for modal to appear


        // Fill up the form using faker class

        // Firstname
        WebElement firstnameInput = driver.findElement(By.name("firstname"));
        String firstName = faker.name().firstName();
        firstnameInput.sendKeys(firstName);
        System.out.println("firstName = " + firstName);

        // Lastname
        WebElement lastnameInput = driver.findElement(By.name("lastname"));
        String lastName = faker.name().lastName();
        lastnameInput.sendKeys(lastName);
        System.out.println("lastName = " + lastName);

        Thread.sleep(1000);

        // Select birth date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = faker.date().birthday();
        String[] dob = sdf.format(birthdate).split("/");


        Select dayInput = new Select(driver.findElement(By.id("day")));
        dayInput.selectByValue(dob[0]);
        System.out.println("day = " + dob[0]);

        Thread.sleep(1000);

        Select monthInput = new Select (driver.findElement(By.id("month")));
        monthInput.selectByValue(dob[1]);
        System.out.println("month = " + dob[1]);

        Thread.sleep(1000);

        Select yearInput = new Select (driver.findElement(By.id("year")));
        yearInput.selectByValue(dob[2]);
        System.out.println("year = " + dob[2]);

        Thread.sleep(1000);

        // Select gender

        String gender = faker.demographic().sex();

        if (gender.equals("Female")) {
            WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
            femaleButton.click();
        }else if (gender.equals("Male")) {
            WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
            maleButton.click();
        } else {
            WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
            customButton.click();

        }

        Thread.sleep(2000);


        // Select Phone number
        String phoneNumber = faker.phoneNumber().cellPhone();
        System.out.println("Mobile Number: " + phoneNumber);



        // Generate email address
        String emailAddress = faker.internet().emailAddress();
        System.out.println("email address = " +emailAddress);

        // Choose either mobile or email
        WebElement mobileoremail = driver.findElement(By.name("reg_email__"));
        mobileoremail.sendKeys(phoneNumber);

        Thread.sleep(2000);

        // Choose New Password
        String password = faker.internet().password();
        WebElement newPassword = driver.findElement(By.name("reg_passwd__"));
        newPassword.sendKeys(password);


        Thread.sleep(2000);


        // Click on Sign Up button
        WebElement signUputton = driver.findElement(By.name("websubmit"));
        signUputton.click();

        // Verify that you landed on the next page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // boolean isNextPage = wait.until(ExpectedConditions.urlContains("facebook.com"));
        //System.out.println("Registration successful: " + isNextPage);

    }
}
