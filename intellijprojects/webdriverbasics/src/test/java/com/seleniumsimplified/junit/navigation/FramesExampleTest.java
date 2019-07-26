package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FramesExampleTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    private WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();
    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/frames/");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }

    @Test
    public void iFrameContent(){

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        wait.until(presenceOfElementLocated(By.cssSelector("h1[id ='green']")));
        driver.findElement(By.cssSelector("a[href='content.html']")).click();
        String title = driver.findElement(By.cssSelector("body > h1")).getText();
        assertThat(title, is("Content"));
    }
    @Test
    public void iFrameExample5(){

        driver.switchTo().frame("menu");
        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();
        wait.until(titleIs("HTML Frames Example - iFrame Contents"));
        driver.switchTo().frame(0);
        wait.until(presenceOfElementLocated(By.cssSelector("p:nth-child(1)")));
        driver.findElement(By.cssSelector("a[href='frames_example_5.html']")).click();
        //      driver.switchTo().frame("content");
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']")).click();

    }
}