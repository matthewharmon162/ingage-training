package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SynchronisationExercisesTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();

    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/basic_ajax.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }


    @Test
    public void assertTitle(){
        String ogTitle = driver.getTitle();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String newTitle = driver.getTitle();
        assertThat(ogTitle, is(not(newTitle)));
    }

    @Test
    public void clearComments(){
        WebElement comments = driver.findElement(By.cssSelector("textarea[name='comments']"));
        comments.clear();
        comments.sendKeys("Hello World");

        driver.findElement(By.cssSelector("input[type='submit']")).click();


        String text = driver.findElement(By.cssSelector("li[id='_valuecomments']")).getText();
        assertEquals("Hello World", text);
    }

    @Test
    public void selectJavaWithSync(){
        driver.findElement(By.cssSelector("option[value='3']")).click();
        wait.until(optionWithValueDisplayed("23")).click();
        driver.findElement(By.cssSelector("input[type ='submit']")).click();
        assertEquals("3", driver.findElement(By.cssSelector("#_valueid")).getText());
        assertEquals("23", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText());

    }

    private ExpectedCondition<WebElement> optionWithValueDisplayed(final String value){
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply( WebDriver webDriver) {
                return webDriver.findElement(
                        By.cssSelector("option[value='" + value + "']"));
            }

            @Override
            public String toString(){
                return "option with value " + value + " displayed";
            }
        };
    }

}
