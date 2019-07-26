package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class JavaExampleTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    WebDriverWait wait;
    private WebElement queryInput ;
    private WebElement submitButton;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();

    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/canvas_basic.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);

    }


    @Test
    public void callAJavaScriptFunctionOnThePAge(){
        JavascriptExecutor js = (JavascriptExecutor)driver;

        int actionsCount = driver.findElements(By.cssSelector("#commandlist li")).size();

        assertEquals("By defaut app has 2 actions listed", 2, actionsCount);

        js.executeScript("draw(1, 150, 150, 40, '#FF1C0A');");

        actionsCount = driver.findElements(By.cssSelector("#commandlist li")).size();
        assertEquals("Calling draw should add an action", 3, actionsCount);

    }

}
