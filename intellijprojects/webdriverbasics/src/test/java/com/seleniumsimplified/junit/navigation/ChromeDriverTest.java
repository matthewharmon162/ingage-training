package com.seleniumsimplified.junit.navigation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ChromeDriverTest {
    @BeforeClass
    public static void setupTheChromoeDriverSystemProperty(){

    }
    @Test
    public void basicChromeUsage(){
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        System.out.println(chrome.getTitle());
        assertThat(chrome.getTitle(), is("Basic Ajax"));
        chrome.quit();
    }
    @Test
    public void basicChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        System.out.println(chrome.getTitle());
        assertThat(chrome.getTitle(), is("Basic Ajax"));
        chrome.quit();
    }
}

