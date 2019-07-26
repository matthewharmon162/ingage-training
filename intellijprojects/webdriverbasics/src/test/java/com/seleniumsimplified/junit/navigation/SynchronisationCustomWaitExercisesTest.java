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

public class SynchronisationCustomWaitExercisesTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/basic_ajax.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }


    @Test
    public void assertTitle(){
        String ogTitle = driver.getTitle();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String newTitle = driver.getTitle();
        assertThat(ogTitle, is(not(newTitle)));
    }

    @Test
    public void clearComments(){
        WebElement comments = driver.findElement(By.cssSelector("textarea[name='comments']"));
        comments.clear();
        comments.sendKeys("Hello World");

        driver.findElement(By.cssSelector("input[type='submit']")).click();


        String text = driver.findElement(By.cssSelector("li[id='_valuecomments']")).getText();
        assertEquals("Hello World", text);
    }

    @Test
    public void selectJavaWithSynCustomClass(){
        driver.findElement(By.cssSelector("option[value='1']")).click();
        wait.until(new SelectContainsText(By.id("combo2"),"VBScript"));
        driver.findElement(By.cssSelector("#combo2 >option[value='2']")).click();
        System.out.print(driver.findElement(By.cssSelector("#combo2 >option[value='2']")).getText());
        driver.findElement(By.cssSelector("input[type ='submit']")).click();
        assertEquals("1", driver.findElement(By.cssSelector("#_valueid")).getText());
        assertEquals("2", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText());

    }
    @Test
    public void selectJavaWithSyncCustomAnonymous(){
        driver.findElement(By.cssSelector("option[value='3']")).click();
        wait .until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver){
                return webDriver.findElement(By.cssSelector("option[value='23']")).isDisplayed();
            }
        });
        driver.findElement(By.cssSelector("option[value='23']")).click();
        driver.findElement(By.cssSelector("input[type ='submit']")).click();
        assertEquals("3", driver.findElement(By.cssSelector("#_valueid")).getText());
        assertEquals("23", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText());

    }

    @Test
    public void selectJavaWithSyncCustomLocal(){
        driver.findElement(By.cssSelector("option[value='3']")).click();
        WebElement javaOption = new WebDriverWait(driver,10).until(optionWithValueDisplayed("23"));
        javaOption.click();
        driver.findElement(By.cssSelector("input[type ='submit']")).click();
        assertEquals("3", driver.findElement(By.cssSelector("#_valueid")).getText());
        assertEquals("23", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText());

    }
    private ExpectedCondition<WebElement> optionWithValueDisplayed(final String value){
        return new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver webDriver){
                return webDriver.findElement(
                        By.cssSelector("option[value= '" + value +"']"));
            }
        };
    }
    @Test
    public void selectJavaWithSyncCustomWebElement(){
        driver.findElement(By.cssSelector("option[value='3']")).click();
        WebElement elly = new WebDriverWait(driver,10).until(
                new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                        WebElement eli = driver.findElement(By.cssSelector("option[value='23']"));

                if(eli.isDisplayed()) {
                        return eli;
                }else{
                        return null;
                    }
                }
             }
            );

        elly.click();
        driver.findElement(By.cssSelector("input[type ='submit']")).click();
        assertEquals("3", driver.findElement(By.cssSelector("#_valueid")).getText());
        assertEquals("23", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText());

    }
}
