package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FindElementExercisesTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/find_by_playground.php");
    }
    @Test
    public void noSuchElementException_thrownWhenLocatorWrong() {

        try {

            WebElement missingElement = driver.findElement(By.id("p2name"));
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {

        }
    }


    @Test
    public void findIdElement(){
        WebElement idElement = driver.findElement(By.id("p1"));
        assertThat(idElement.getText(), is("This is a paragraph text"));
    }

    @Test
    public void findLinkTextElement(){
        WebElement linkTextElement = driver.findElement(By.linkText("jump to para 0"));
        assertThat(linkTextElement.getAttribute("id"), is("a26"));
    }

    @Test
    public void findNameElement(){
        WebElement nameElement = driver.findElement(By.name("pName6"));
        assertThat(nameElement.getText(), is("This is f paragraph text"));
    }

    @Test
    public void findPartialLinkElement(){
        WebElement partialLinkTextElement = driver.findElement(By.partialLinkText("para 10"));
        assertThat(partialLinkTextElement.getText(), is("jump to para 10"));
    }

    @Test
    public void findClassName(){
        WebElement classNameElement = driver.findElement(By.className("specialDiv"));
        assertThat(classNameElement.getAttribute("id"), is("div1"));
    }
}
