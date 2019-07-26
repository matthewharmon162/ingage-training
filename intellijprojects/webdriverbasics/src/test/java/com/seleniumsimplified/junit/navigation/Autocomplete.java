package com.seleniumsimplified.junit.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("123 Fake Street");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item"))).click();

        driver.quit();
    }

}
