package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JavascriptAsyncExampleTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/basic_ajax.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
        driver.navigate().refresh();
    }


    @Test
    public void synOnAjaxGifRemovalViaAsync(){
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        js.executeScript("window.webdrivercallback = function(){};" +
                "var oldhide = $.fn.hide;" +
                "$.fn.hide = function(speed,callback) {" +
                "   var retThis = oldhide.apply(this.arguments);" +
                "   window.webdrivercallback.apply();" +
                "   return retThis;" +
                "};"
        );

        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='3']")).click();

        js.executeAsyncScript("window.webdrivercallback = arguments[arguments.length - 1];");

        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='23']")).click();

        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23", languageWeUsed.getText());
    }


}
