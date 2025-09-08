package com.seleniumproject.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C01_JavaFaker {

    /*
    Java Faker is used to get fake data for testing purpose.
    Where do we get the test data?
        - BA
        - Test Lead
        - Manual Tester
        - Developers
        - Team Lead
        - Database Call - not recommended for testing
        - API call - not recommended for testing
        - Java faker  - it randomly generates data. Use it only if company allows!
     Test Data: username, password, address etc.


     */
    @Test
    public void fakerTest(){
        // 1. Create Faker object
        Faker faker = new Faker();

        // 2. Create fake data
        // Firstname
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        // Lastname
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        // Username
        String userName = faker.name().username();
        System.out.println("userName = " + userName);

        // Title
        String title = faker.name().title();
        System.out.println("title = " + title);

        // Address
        String fullAddress = faker.address().fullAddress();
        System.out.println("fullAddress = " + fullAddress);

        // Cell Phone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println("cellPhone = " + cellPhone);

        // Email
        String email = faker.internet().emailAddress();
        System.out.println("email = " + email);

        // Password
        String password = faker.internet().password();
        System.out.println("password = " + password);

        // Random number
        int randomNumber = faker.number().numberBetween(100, 100000);
        System.out.println("randomNumber = " + randomNumber);

        System.out.println(faker.number().digits(10));


    }

}
