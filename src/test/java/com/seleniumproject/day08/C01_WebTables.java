package com.seleniumproject.day08;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C01_WebTables extends TestBase {

    /*
    Go to https://the-internet.herokuapp.com/tables
    Task 1 : Print the entire table and Assert if the last element in the table 1 is "edit delete"
    Task 2 : Print All Rows
    Task 3 : Print Last row data only
    Task 4 : Print column 5 data in the table body
    Task 5 :  Print the information of columns 1 and 2 in 3 rows
    Task 6 : Write a method that accepts 2 parameters
    Parameter 1 = row number
    Parameter 2 = column number
    printData(2,3);	=> prints data in 2nd row 3rd column

     */

    @Test
    public void printTableData(){
//        Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        System.out.println("========== Task 1 ========== ");
//        Task 1 : Print the entire table and Assert if the last element in the table 1 is "edit delete"
        WebElement entireTable = driver.findElement(By.id("table1"));
        String entireTableText = entireTable.getText();
        System.out.println("entireTableText = " + entireTableText);

        System.out.println("========================");
        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));

        for (WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());
        }

        // Assert if the last element in the table 1 is "edit delete"
        System.out.println(allTableElements.size()); // 24
        System.out.println(allTableElements.get(0).getText()); // Smith
        System.out.println(allTableElements.get(allTableElements.size() - 1).getText()); // edit delete

        assertEquals("edit delete", allTableElements.get(allTableElements.size() - 1).getText() );

        System.out.println("=========Checking if John exists ===========");
        for (WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());

            if (eachElement.getText().equals("John")){
                System.out.println(eachElement.getText());
                break;
            }
        }

        System.out.println("=============== ALTERNATIVELY ================ ");
        WebElement givenElement = allTableElements.get(1);
        System.out.println(givenElement.getText());
        assertTrue(givenElement.getText().equals("John"));



        System.out.println("========== Task 2 ========== ");

//        Task 2 : Print All Rows
        List <WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        for (WebElement eachRow : allRows){
            System.out.println(eachRow.getText());
        }
        System.out.println("======================");
        // Print rows with row number
        int rowNumb = 1;
        for (WebElement eachRow : allRows){
            System.out.println( "Row "+rowNumb+ " => " + eachRow.getText());
            rowNumb++;
        }


//        Task 3 : Print Last row data only
        System.out.println("========== Task 3 ========== ");
        System.out.println("Last row data = " + allRows.get(4).getText()); // hard coded index for last row --- not recommended

        System.out.println("Last row data = " + allRows.get(allRows.size()-1).getText()); // Dynamic way of getting index for last row

        System.out.println("========================");
        // OR retrieve the last row ONLY through driver
        WebElement lastRowOnly = driver.findElement(By.xpath("//table[@id='table1']//tr[4]"));
        System.out.println("lastRowOnly = " + lastRowOnly.getText());


//        Task 4 : Print column 5 data in the table body
        System.out.println("============ Task 4  ============");
        // driver.findElement(By.xpath("//table[@id='table1']//tr//td[5]")); //tr is not mandatory in this case
        List <WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        int rowNumber = 1;
        for (WebElement eachElement : col5Data){
            System.out.println("Row "+rowNumber + " Col. 5 => " + eachElement.getText());
            rowNumber++;
        }

        System.out.println("============= Task 5 =================");

//        Task 5 :  Print the information of columns 1 and 2 in 3rd row
        List<WebElement> row3ColOneTwo = driver.findElements(By.xpath("//table[@id='table1']//tr[3]//td[position() >=1 and position() <=2]"));

        for (WebElement w: row3ColOneTwo){
            System.out.println("row3ColOneTwo data = " + w.getText());
        }

        // HW:     Task 6 : Write a method that accepts 2 parameters
        //    Parameter 1 = row number
        //    Parameter 2 = column number
        //    printData(2,3);	=> prints data in 2nd row 3rd column
        // Method call:
        // printData(2,3);	 //	fbach@yahoo.com
        // Create HW03 class in hw package and replace all the loops above with lambda

    }






}
