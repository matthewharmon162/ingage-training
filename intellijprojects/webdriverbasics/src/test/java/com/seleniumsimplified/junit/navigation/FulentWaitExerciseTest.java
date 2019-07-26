package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FulentWaitExerciseTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    private WebDriverWait wait;

//    @BeforeClass
//    public static void createDriver(){
//
//        driver = Driver.get();
//
//    }
//    @Before
//    public void navigateURL(){
//
//        driver.navigate().to(ROOT_URL + "/selenium/javascript_countdown.html");
//        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
//    }
//
//
//
//    @Test
//    public void fluentWait() {
//        String theTime = new FluentWait<WebElement>(countdown).
//                withTimeout(10, TimeUnit.SECONDS).
//                pollingEvery(50, TimeUnit.MILLISECONDS).
//                until(new Function<WebElement, String>(){
//                    @Override
//                    public String apply(WebElement element) {
//                        return element.getText().endsWith("04") ? element.getText() : null;
//                    }
//                }
//                );
//        assertEquals("Expected a different time", "01:01:04", theTime);
//    }
//
//    @Test
//    public void fluentWaitFunction() {
//        String theTime = new WebDriverWait(driver,10,100).
//                until(new Function<WebElement, String>(){
//                          @Override
//                          public String apply(WebElement driver) {
//                              WebElement countDown = driver.findElement(By.id("javascript_countdown_time"));
//                              return countDown.getText().endsWith("04") ? countDown.getText() : null;
//                          }
//                      }
//                );
//        assertEquals("Expected a different time", "01:01:04", theTime);
//    }
//    @Test
//    public void fluentWaitExpetedCondition() {
//        String theTime = new WebDriverWait(driver,10,100).
//                until(new ExpectedCondition<String>() {
//                          @Override
//                          public String apply(WebElement driver) {
//                              WebElement countDown = driver.findElement(By.id("javascript_countdown_time"));
//                              return countDown.getText().endsWith("04") ? countDown.getText() : null;
//                          }
//                      }
//                );
//        assertEquals("Expected a different time", "01:01:04", theTime);
//    }
//    @Test
//    public void fluentWaitBasic() {
//        String theTime = new WebDriverWait(driver,10,100).
//                until(new ExpectedCondition<String>() {
//                          @Override
//                          public String apply(WebElement driver) {
//                              WebElement countDown = driver.findElement(By.id("javascript_countdown_time"));
//                              return countDown.getText().endsWith("04") ? countDown.getText() : null;
//                          }
//                      }
//                );
//        assertEquals("Expected a different time", "01:01:04", theTime);
//    }
}
