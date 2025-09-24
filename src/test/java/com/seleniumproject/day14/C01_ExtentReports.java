package com.seleniumproject.day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.TestBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class C01_ExtentReports extends TestBase {
    /*
    3 Keywords to remember regarding EXTENT REPORTS
     - ExtentReports
     - ExtentHtmlReporter
     - ExtentTest
     */

    protected static ExtentReports extentReports;               // This class is used for file generation, creates an empty report template
    protected static ExtentHtmlReporter extentHtmlReporter;     // his class is used to add configuration information e.g. document title, author name, report name etc.
    protected  static ExtentTest extentTest;                    // This class is used for logging information



    @BeforeAll
    public static void extentSetUp(){
        // 1.  Create the path where you want to store extent reports
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+ "/test-output/Reports/" +now+ "report.html";

        // 2. Pass the path variable to HTML reporter
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // 3. Initialise the extentReports object to generate the report template
        extentReports = new ExtentReports();  // creates an empty report template, to which we can add the custom configurations

//      *******************************

        // 4. Add custom information (OPTIONAL)
        extentReports.setSystemInfo("Test Environment", "Smoke Test"); // or Regression, UAT etc.
        extentReports.setSystemInfo("Application", "TechProEducation");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Learners");
        extentReports.setSystemInfo("QA", "John");
        extentReports.setSystemInfo("Sprint 5", "Au2025");

        // 5. Add some custom configuration for report header (RECOMMENDED)
        extentHtmlReporter.config().setReportName("TechPro Education LMS");
        extentHtmlReporter.config().setDocumentTitle("TechPro Extent Reports");

//      *******************************

        // 6. Configuration done!. Now attach the two (extentReports + extentHtmlReporter)
        extentReports.attachReporter(extentHtmlReporter);

        // Attachment done!
        // 7. Initialise extent test
        extentTest = extentReports.createTest("Extent Reporter" , "Smoke Test Report");


    }
    @AfterAll
    public static void extentReportsFlush(){
        // NOTE: MANDATORY => Without flush() method, reports will NOT be generated
        // 8. Generate the reports
        extentReports.flush();
    }

    @Test
    public void extentReportTest(){
        // Go to https://lms.techproeducation.com/
        driver.get("https://lms.techproeducation.com/");
        extentTest.pass("User is on TechPro LMS Page");
        waitFor(2);

        // Click on LMS Login
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();
        extentTest.pass("Login BUtton is clicked successfully");
        waitFor(2);

        // Verify the login page is visible
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://lms.techproeducation.com/login/";

        assertEquals(expectedUrl, actualUrl, "LMS Login Page is not visible!");
        waitFor(2);

        extentTest.pass("Login details are visible");
        extentTest.info("User needs to provide their Login credentials.");
        extentTest.log(Status.PASS, "Login Test"); // Status is enum structure which stores constants



    }

    @Test
    public void extentReportTest2(){
        // Examples how to use different extentTest methods
        extentTest.info("Login should be active after registration");
        extentTest.warning("Pay attention to Login button display");
        extentTest.fail("Login button is not interacting");
        extentTest.skip("Registration is skipped for this test");
        extentTest.pass("Login is successful!");

        // NOTE: These methods act like System.out.println();
        // System.out.println(); prints on the console
        // extentTest methods print on the HTML reports

        driver.get("https://www.amazon.com");
        extentTest.pass("On Amazon Homepage");
        extentTest.log(Status.PASS, "Amazon homepage");
        waitFor(2);

        // Assert that amazon title is visible

        if ( driver.getTitle().contains("amazon")){
            assertTrue(driver.getTitle().contains("amazon"));
            extentTest.pass("Actual Title is Amazon");
        }else {
            extentTest.fail("Actual Title is Amazon");
            assertTrue(driver.getTitle().contains("amazon"));
        }


    }

      /*

Extent reports is document generation API so that we can add some custom text on the report.
They are ready templates for reports. But we can customise them.
Extent REPORTS ARE NOT PART OF SELENIUM. We just need to add a dependency in our framework.
It's another tool (just like java faker), which makes our testing framework more powerful.

Extent Report API is used to generate custom HTML reports.
We can add company or project specific information in the report configuration.
These reports can be uploaded on JIRA and shared with the team.

In short, Extent reports is a dependency that I use in my framework for generating custom html reports.
I get that dependency from the COMPANY internal repository.

Benefits:
- Open source
- Works with different browsers and platforms
- Works with different frameworks e.g. junit, testng, cucumber
- it's customizeable
- we can log/print each step

Set Up:

For this we used this repository/dependency
https://mvnrepository.com/artifact/com.aventstack/extentreports


<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>4.0.9</version>
</dependency>

1. Create Report Path
2. Create HTML report in the path
3. Create extent reports object for generating the Entire reports with configuration
4. Customise System Info
5. Add more custom config info
6. Done With Configuration (attachReporter)
7. Create extent test
8. Use reports
9. Generate the report using flush method

     */


}
