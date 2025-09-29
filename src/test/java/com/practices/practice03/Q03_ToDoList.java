package com.practices.practice03;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_ToDoList extends TestBase {
        /*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strike through all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
*/

    @Test
    public void toDoListTest(){

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> jobList = new ArrayList<>(Arrays.asList("Prepare breakfast" , "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

        for (String eachTask: jobList){
            inputField.sendKeys(eachTask, Keys.ENTER);
//            waitFor(1);
        }


//        Strike through all todos.
        List<WebElement> toDoList = driver.findElements(By.xpath("//ul/li"));

        for (WebElement each : toDoList){
            System.out.println(each.getText());
        }


        for (WebElement each : toDoList){
            each.click();
//            waitFor(1);
        }


//        Delete all todos.
        List<WebElement> deleteIcons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for (WebElement w : deleteIcons){
            w.click();
//            waitFor(1);
        }

//        Assert that all todos deleted.
        waitFor(2);
        assertTrue(driver.findElements(By.xpath("//li")).isEmpty());

    }
}
