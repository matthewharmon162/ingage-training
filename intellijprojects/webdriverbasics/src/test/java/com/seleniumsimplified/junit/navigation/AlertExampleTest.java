package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class AlertExampleTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();
    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/alerts.html");
    }

    @Test
    public void acceptAndDismissAlert(){
        WebElement alertButton = driver.findElement(By.id("alertexamples"));
        alertButton.click();
        String text = driver.switchTo().alert().getText();
        assertEquals("I am an alert box!", text);
        driver.switchTo().alert().dismiss();

    }
    @Test
    public void acceptAndDismissConfirm(){
        WebElement confirmButton = driver.findElement(By.id("confirmexample"));
        confirmButton.click();
        driver.switchTo().alert().accept();
        String text =  driver.findElement(By.cssSelector("#confirmreturn")).getText();
        assertEquals("true", text);


    }


    @Test
    public void acceptAndDismissPrompt(){
        WebElement promptButton = driver.findElement(By.id("promptexample"));
        promptButton.click();
        driver.switchTo().alert().accept();
        String text =  driver.findElement(By.cssSelector("#promptreturn")).getText();
        assertEquals("change me", text);


    }
    @Test
    public void acceptAndDismissPromptChange(){
        WebElement promptButton = driver.findElement(By.id("promptexample"));
        promptButton.click();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        String text =  driver.findElement(By.cssSelector("#promptreturn")).getText();
        assertEquals("hello", text);


    }

}
