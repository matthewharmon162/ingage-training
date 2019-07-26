package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class InterrogationExampleTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();
    }
    @Test
    public void navigateBasicWebPage(){
        driver.navigate().to(ROOT_URL + "/selenium/basic_web_page.html");

        assertThat(driver.getTitle(), is("Basic Web Page Title"));
        //System.out.print(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().startsWith("http://www.compendiumdev.co.uk/selenium/basic_web_page.html"));
       // assertTrue(driver.getPageSource().contains("A paragraph of text"));
        assertThat(driver.getPageSource(), containsString("A paragraph of text"));
        System.out.print(driver.getPageSource());
    }
}
