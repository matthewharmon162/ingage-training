package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WindowExampleTest {

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
    public void switchToNewWindow(){
        String framesWindowHandle = driver.getWindowHandle();
        assertTrue(driver.getTitle().contains(("Frameset Example")));
        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
        assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());
        Set<String> myWindows = driver.getWindowHandles();
        String newWindowHandle="";
        for(String aHandle : myWindows){
            if(!framesWindowHandle.contentEquals(aHandle)){
                newWindowHandle = aHandle; break;
            }
        }
        driver.switchTo().window(newWindowHandle);
        assertTrue("Expected Selenium Simplified site",
                driver.getTitle().contains("Selenium Simplified"));
        driver.switchTo().window(framesWindowHandle);
        assertTrue(driver.getTitle().contains(("Frameset Example")));
    }
    @Test
    public void switchToNewWindowByName(){
        String framesWindowHandle = driver.getWindowHandle();
        assertTrue(driver.getTitle().contains(("Frameset Example")));
        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("#goevil")).click();
        driver.findElement(By.cssSelector("a[target='compdev']")).click();
        assertEquals("Expected a New Window opened", 3, driver.getWindowHandles().size());

        driver.switchTo().window("compdev");
        assertTrue("Expected Software Testing site",
                driver.getTitle().contains("Software Testing"));
        driver.switchTo().window("evil");
        assertTrue("Expected Evil Tester site",
                driver.getTitle().contains("EvilTester"));
        driver.switchTo().window(framesWindowHandle);
        assertTrue(driver.getTitle().contains(("Frameset Example")));
    }
}