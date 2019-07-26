package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FindElementCSSExercisesTest {

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
    public void findIdElement(){
        WebElement element = driver.findElement(By.cssSelector("#p31"));
        assertThat(element.getAttribute("name"), is("pName31"));
    }

    @Test
    public void findNameElement(){
        WebElement element = driver.findElement(By.cssSelector("#ul1"));
        assertThat(element.getAttribute("id"), is("ul1"));
    }

    @Test
    public void findClassNameElement(){
        WebElement element = driver.findElement(By.cssSelector("div[class='specialDiv']"));
        assertThat(element.getAttribute("id"), is("div1"));
    }

    @Test
    public void findtagNameElement(){
        WebElement element = driver.findElement(By.cssSelector("li[id=li1]"));
        assertThat(element.getAttribute("name"), is("liName1"));
    }


}
