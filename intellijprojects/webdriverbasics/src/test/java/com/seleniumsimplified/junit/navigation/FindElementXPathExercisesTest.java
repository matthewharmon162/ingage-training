package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindElementXPathExercisesTest {

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
        WebElement element = driver.findElement(By.xpath("//div/p[@id='p31']"));
        assertThat(element.getAttribute("name"), is("pName31"));
    }

    @Test
    public void findNameElement(){
        WebElement element = driver.findElement(By.xpath("//div/ul"));
        assertThat(element.getAttribute("id"), is("ul1"));
    }

    @Test
    public void findClassNameElement(){
        WebElement element = driver.findElement(By.xpath("//div[@class='specialDiv']"));
        assertThat(element.getAttribute("id"), is("div1"));
    }

    @Test
    public void findtagNameElement(){
        WebElement element = driver.findElement(By.xpath("//li"));
        assertThat(element.getAttribute("name"), is("liName1"));
    }


}
