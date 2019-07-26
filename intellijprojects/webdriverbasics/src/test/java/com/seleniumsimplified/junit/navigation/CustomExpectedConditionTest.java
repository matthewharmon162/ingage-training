package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CustomExpectedConditionTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    private WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();

    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/basic_redirect.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }



    @Test
    public void click5WithSyncCustomLocal() throws InterruptedException {
        driver.findElement(By.cssSelector("a#delaygotobasic")).click();
        assertEquals("Basic Web Page Title", new WebDriverWait
                (driver,10).until(new TitleDoesNotContain("Basic Redirects")));
        Thread.sleep(1000);

    }
    @Test
    public void click2WithSyncCustomLocal() throws InterruptedException {
        driver.findElement(By.cssSelector("a#delaygotobounce")).click();
        assertEquals("Bounce", new WebDriverWait
                (driver,10).until(new TitleDoesNotContain("Basic Redirects")));
        Thread.sleep(1000);

    }
    private class TitleDoesNotContain implements ExpectedCondition<String>{
        private String titleExcludes;
        public TitleDoesNotContain(String notContainThisString) {
            this.titleExcludes = notContainThisString;
        }
            @Override
            public String apply(WebDriver webDriver){
                String title = webDriver.getTitle();

                if(title.contains(this.titleExcludes)) {
                    return null;
                }else{
                    return title;
                }

            }
        }


}
