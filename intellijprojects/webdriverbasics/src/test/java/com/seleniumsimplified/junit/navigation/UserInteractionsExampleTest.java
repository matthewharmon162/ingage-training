package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserInteractionsExampleTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/gui_user_interactions.html");
    }

    @Test
    public void dragAndDrop1to1(){
        WebElement draggable1 =driver.findElement(By.cssSelector("div[id=draggable1]"));
        WebElement droppable1 =driver.findElement(By.cssSelector("div[id=droppable1]"));
        new Actions(driver).dragAndDrop(draggable1,droppable1 ).perform();
        String text= droppable1.getText();
        assertEquals("Dropped!",text );
    }

    @Test
    public void dragAndDrop2to1(){
        WebElement draggable2 =driver.findElement(By.cssSelector("div[id=draggable2]"));
        WebElement droppable1 =driver.findElement(By.cssSelector("div[id=droppable1]"));
        new Actions(driver).dragAndDrop(draggable2,droppable1 ).perform();
        String text= droppable1.getText();
        assertEquals("Get Off Me!",text );
    }
    @Test
    public void controlB(){
        WebElement draggable1 =driver.findElement(By.cssSelector("div[id=draggable1]"));
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("b").build().perform();

        String text= draggable1.getText();
        assertEquals("Bwa! Ha! Ha!",text );
    }

    @Test
    public void controlSpace(){
        WebElement droppable1 =driver.findElement(By.cssSelector("div[id=droppable1]"));
        WebElement droppable2 =driver.findElement(By.cssSelector("div[id=droppable2]"));
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).build().perform();
//        String text1= droppable1.getText();
//        String text2= droppable2.getText();
//        assertEquals("Let GO!!!",text1 );
//        assertEquals("Let GO!!!",text2 );
    }
    @Test
    public void draw() throws InterruptedException {
        WebElement canvas =driver.findElement(By.cssSelector("canvas"));
        Actions action = new Actions(driver);
        action.clickAndHold(canvas).moveByOffset(100,100).build().perform();

    }

}
