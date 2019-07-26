package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CookiesExercisesTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;
    WebDriverWait wait;
    private WebElement queryInput ;
    private WebElement submitButton;

    @BeforeClass
    public static void createDriver(){

        driver = Driver.get();

    }
    @Before
    public void navigateURL(){

        driver.navigate().to(ROOT_URL + "/selenium/search.php");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
        driver.manage().deleteAllCookies();
        queryInput = driver.findElement(By.name("q"));
        submitButton = driver.findElement(By.name("btnG"));
    }


    @Test
    public void searchAndCheckForAllCookies(){
        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        Set<Cookie> cookies= driver.manage().getCookies();
        for(Cookie aCookie : cookies){
            if(aCookie.getName().contentEquals("seleniumSimplifiedSearchNumVisits")){
                assertEquals("Should be my first visit", String.valueOf(1), aCookie.getValue());
            }
        }

    }
    @Test
    public void getCookieDirectly() {
        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        Cookie aCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("Should be my first visit", 1, Integer.parseInt(aCookie.getValue()));

    }
    @Test
    public void changeCookieVisitsCount() throws InterruptedException {
        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        queryInput = driver.findElement(By.name("q"));
        submitButton = driver.findElement(By.name("btnG"));

        Cookie aCookie= driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("Should be my first visit",1, Integer.parseInt(aCookie.getValue()));
        Cookie aCookieNumVisit = new Cookie(aCookie.getName(),
                String.valueOf(42),
                aCookie.getDomain(),
                aCookie.getPath(),
                aCookie.getExpiry(),
                aCookie.isSecure());

        driver.manage().deleteCookie(aCookie);
        driver.manage().addCookie(aCookieNumVisit);

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        System.out.print(aCookieNumVisit.getValue());
        aCookie= driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("43", aCookie.getValue());
    }
    @Test
    public void changeCookieVisitsCountBioBuilder() throws InterruptedException {
        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        queryInput = driver.findElement(By.name("q"));
        submitButton = driver.findElement(By.name("btnG"));

        Cookie aCookie= driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("Should be my first visit",1, Integer.parseInt(aCookie.getValue()));
        Cookie aCookieNumVisit = new Cookie.Builder(aCookie.getName(),
                String.valueOf(42))
                .domain(aCookie.getDomain())
                .path(aCookie.getPath())
                .expiresOn(aCookie.getExpiry())
                .isSecure(aCookie.isSecure()).build();

        driver.manage().deleteCookie(aCookie);
        driver.manage().addCookie(aCookieNumVisit);

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();

        System.out.print(aCookieNumVisit.getValue());
        aCookie= driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("43", aCookie.getValue());
    }
    @Test
    public void changeCookieVisitsCountSimply(){
        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();


        queryInput = driver.findElement(By.name("q"));
        submitButton = driver.findElement(By.name("btnG"));

        driver.manage().deleteCookieNamed("seleniumSimplifiedSearchNumVisits");
        driver.manage().addCookie(new Cookie.Builder("seleniumSimplifiedSearchNumVisits",
                String.valueOf(42)).
                path("/selenium").build());

        queryInput.clear();
        queryInput.sendKeys("Cookie Test");
        submitButton.click();


        Cookie aCookie= driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        assertEquals("43", aCookie.getValue());
    }
}
