package com.seleniumsimplified.junit.navigation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SlowLoadingTest {
    private static WebDriver driver;

    @BeforeClass
    public static void startSelenium(){
        driver = new FirefoxDriver();
    }

    @Test
    public void useInBuiltExpectedConditions(){
        SlowLoadingExampleTest page4 = new SlowLoadingExampleTest(driver);
        page4.get();

        page4.
                setName("Bob Dobbs").
                setEmail("b.dobbs@mailinator.com").
                setMessage("Hello There").
                sendMessage();
    }

    @AfterClass
    public static void closeSelenium(){
        driver.quit();
    }
}
