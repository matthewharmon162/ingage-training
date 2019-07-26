package com.seleniumsimplified.junit.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecuteJavascript {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
     //   WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://formy-project.herokuapp.com/modal");


        driver.findElement(By.id("modal-button")).click();


        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.id("close-button")));

        driver.quit();
    }

}
