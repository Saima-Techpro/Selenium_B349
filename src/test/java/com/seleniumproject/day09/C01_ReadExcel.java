package com.seleniumproject.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C01_ReadExcel {

    //NOTE; Apache POI is the library used to work with Excel files in Selenium


    @Test
    public void readExcel() throws IOException {
        // Store the path od the file in a String
        String path = "resources/Capitals.xlsx";

        // To reach the Excel file, we need FileInputStream Java class
        // 1. Create its object and pass the path where the file is located
        FileInputStream fileInputStream = new FileInputStream(path);

        // Workbook -> Sheet -> Row -> Cell
        // 2.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Open the first sheet
        Sheet sheet1 = workbook.getSheet("Sheet1");

        // Go to first row
        Row row1 = sheet1.getRow(0); // index starts at 0, going to the first row

        // Go to first cell in the first row and print the data
        Cell cell1 = row1.getCell(0);
        System.out.println("cell1 = " + cell1);

        // Get the data from row1 and second cell
        Cell cell2 = row1.getCell(1);
        System.out.println("cell2 = " + cell2);

        // Shorter way: Chaining the methods
        System.out.println(sheet1.getRow(0).getCell(1));

        // Task 1: Go to 2nd row and first cell and assert that the data is equal to USA
        Row row2 = sheet1.getRow(1);

        Cell row2Cell1 = row2.getCell(0);
        System.out.println("row2Cell1 = " + row2Cell1); // USA but the data type here is Cell

        assertEquals("USA" , row2Cell1.toString()); // now both have the same data type

        // Task 2: Go to 3rd row, 2nd cell - chain the row and cell
        String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println("row3Cell2 = " + row3Cell2);
        assertEquals("Paris" , row3Cell2);

        // Task 3: Find the number of rows
        int numOfRows = sheet1.getLastRowNum() + 1; // index starts at 0, so we add 1 to find the total number of rows
        System.out.println("numOfRows = " + numOfRows); // 11

        // Find the number of used rows
        int usedRows = sheet1.getPhysicalNumberOfRows(); // this method starts counting from 1, it will skip the rows if there's no data
        System.out.println("usedRows = " + usedRows);



        // Task 4: Print Country and Capital key value pairs as map object
        Map<String, String> countryCapitalPair = new HashMap<>();  // empty map to store the values
        for (int rowNumb = 1 ; rowNumb < numOfRows; rowNumb++ ){
            String countryName = sheet1.getRow(rowNumb).getCell(0).toString();
            String capitalName = sheet1.getRow(rowNumb).getCell(1).toString();
            countryCapitalPair.put(countryName, capitalName);

        }
        System.out.println("countryCapitalPair = " + countryCapitalPair);


        // Close the workbook
        workbook.close();
        // Close the Excel file
        fileInputStream.close();

           /*
       HOMEWORK : Print country, capital key value pairs as map object()
        create a map
        then use a loop to add key-value pairs in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */

    }
}
