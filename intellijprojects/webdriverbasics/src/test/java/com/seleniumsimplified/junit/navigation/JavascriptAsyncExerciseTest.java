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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class JavascriptAsyncExerciseTest {

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
    public void waitInBrowserForTimeSample(){


        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length -1 ], 500);");

        System.out.println("Elapsed time: "+ (System.currentTimeMillis()-start));
        assertTrue("Elapsed time should be greater than 500 milli", (System.currentTimeMillis()- start > 500));

    }


    @Test
    public void useXMLHttpRequest(){
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        Object response = ((JavascriptExecutor) driver).executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "var xhr = new XMLHttpRequest();" +
                        "xhr.open('GET', '/selenium/ajaxselect.php?id=2', true);" +
                        "xhr.onreadystatechange = function() {" +
                        " if (xhr.readyState == 4) {" +
                        "     callback(xhr.responseText);" +
                        "  }" +
                        "};" +
                        "xhr.send();");


        System.out.println((String)response);
        assertThat((String) response,
                containsString("{optionValue:10, optionDisplay: 'C++'}"));
    }


}
