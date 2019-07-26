package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FindElementsExercisesTest {

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
    public void findClassName(){
        List<WebElement> classNameElements = driver.findElements(By.className("normal"));
        Set<String> foundTags = new HashSet<String>();

        for(WebElement e : classNameElements){
            foundTags.add(e.getTagName());
        }

        assertTrue("expected p tag", foundTags.contains("p"));
    }

    @Test
    public void findDiv(){
        List<WebElement> divElements = driver.findElements(By.tagName("div"));
        int listSize = divElements.size();
        assertEquals(19, listSize);
    }

    @Test
    public void findA(){
        List<WebElement> aElements = driver.findElements(By.partialLinkText("jump to para"));
        int listSize = aElements.size();
        assertEquals(25, listSize);
    }
    @Test
    public void findNestedParagraphs(){
        List<WebElement> nestedDivElements = driver.findElements(By.name("nestedDiv"));
        int listSize = nestedDivElements.size();
        assertEquals(16, listSize);
    }
    @Test
    public void findParagraphs(){
        List<WebElement> divElements = driver.findElements(By.tagName("p"));
        int listSize = divElements.size();
        assertEquals(41, listSize);
    }

}