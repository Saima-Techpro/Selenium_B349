package com.seleniumproject.day08;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void cookieTest(){
        driver.get("https://www.amazon.com");

        // Refresh amazon
        driver.navigate().refresh();


        // 1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();
        System.out.println("numberOfCookies = " + numberOfCookies);


        System.out.println("======================");
        // Print all cookies

        for (Cookie eachCookie : allCookies){
            System.out.println("eachCookie = " + eachCookie);
            System.out.println("Cookie Name = " + eachCookie.getName()); // csm-sid
            System.out.println("Cookie Value = " + eachCookie.getValue()); // 526-8383676-4586453
            System.out.println("Cookie Domain = " + eachCookie.getDomain());
            System.out.println("Cookie Expiry = " + eachCookie.getExpiry());
        }

        // Get the cookie by its name
        System.out.println("Get cookie by name: " +driver.manage().getCookieNamed("csm-sid"));
        System.out.println("================================");
        // Add a new cookie
        Cookie myCookie = new Cookie("my-favourite-cookie", "choc-chip");
        driver.manage().addCookie(myCookie);

        Set<Cookie> newCookies = driver.manage().getCookies();
        for (Cookie eachCookie : newCookies){
            System.out.println("eachCookie = " + eachCookie);
        }
        System.out.println("Number of new Cookies = " + newCookies.size()); // 10

        System.out.println("===========================");
        // Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        int numOfCookiesAfterDeleting = driver.manage().getCookies().size();
        System.out.println("number of Cookies After Deleting = " + numOfCookiesAfterDeleting);

        System.out.println("=======================");
        // Delete all cookies
        driver.manage().deleteAllCookies();
        int numOfCookiesDeletingAll = driver.manage().getCookies().size();
        System.out.println("num of Cookies After Deleting All = " + numOfCookiesDeletingAll);


    }
}
