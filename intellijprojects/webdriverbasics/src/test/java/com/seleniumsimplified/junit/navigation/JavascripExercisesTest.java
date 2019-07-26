package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JavascripExercisesTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/canvas_basic.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
        driver.navigate().refresh();
    }


    @Test
    public void callAJavaScriptFunctionOnThePAge(){
        JavascriptExecutor js = (JavascriptExecutor)driver;

        int actionsCount = driver.findElements(By.cssSelector("#commandlist li")).size();

        assertEquals("By defaut app has 2 actions listed", 2, actionsCount);

        for(int testLoop=0; testLoop<10; testLoop++) {
            js.executeScript("draw(0, arguments[0],arguments[1], 20, arguments[3]);",
                    testLoop*20,
                    testLoop*20,
                    "#" + testLoop + testLoop + "0000");

        }
        actionsCount = driver.findElements(By.cssSelector("#commandlist li")).size();
        assertEquals( 12, actionsCount);

    }

    @Test
    public void returnValueFromJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        assertEquals("Javascript should calc correctly", 40L,
                js.executeScript("return(arguments[0}+arguments[1];", 20, 20));
    }

    @Test
    public void changeTitleUsingJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.title=arguments[0]", "bob");
        assertEquals("bob", driver.getTitle());
    }

    @Test
    public void hideBodyUsingJavaScript(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        assertTrue(driver.findElement(By.cssSelector("#command")).isDisplayed());
        js.executeScript("$('body').hide();");
        assertFalse(driver.findElement(By.cssSelector("#command")).isDisplayed());
    }
    @Test
    public void javascriptRunAsAnonymousFunction() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('alert triggered by webdriver');");
        assertThat(driver.switchTo().alert().getText(), is("alert triggered by webdriver"));

        driver.switchTo().alert().accept();

//        js.executeScript("window.webdriveralert = function(){alert('stored alert triggered by webdriver');}" +
//               "window.webdriveralert.call();");

        js.executeScript("window.webdriveralert = function(){alert('stored alert triggered by webdriver');}");
        js.executeScript("window.webdriveralert.call();");
        assertThat(driver.switchTo().alert().getText(), is("stored alert triggered by webdriver"));
        driver.switchTo().alert().accept();

        js.executeScript("window.webdriveralert.call();");
        assertThat(driver.switchTo().alert().getText(), is("stored alert triggered by webdriver"));
        driver.switchTo().alert().accept();
    }

}
