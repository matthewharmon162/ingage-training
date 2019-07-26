package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManageWindowExampleTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/bounce.html");
        wait = new WebDriverWait(driver,Driver.DEFAULT_TIMEOUT_SECONDS);
    }

    @Test
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }
    @Test
    public void halfSizeWindow(){
        driver.manage().window().maximize();
        Dimension fullScreenSize = driver.manage().window().getSize();
        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth()/2,fullScreenSize.getHeight()/2));
        assertEquals(fullScreenSize.getWidth()/2, driver.manage().window().getSize().getWidth());
        assertEquals(fullScreenSize.getHeight()/2, driver.manage().window().getSize().getHeight());
    }
    @Test
    public void moveHalfSizeToCenterTheWindow(){
        driver.manage().window().maximize();
        Dimension fullScreenSize = driver.manage().window().getSize();
        Point pos =driver.manage().window().getPosition();
        driver.manage().window().setSize(new Dimension(fullScreenSize.getWidth()/2,fullScreenSize.getHeight()/2));
        driver.manage().window().setPosition(new Point(fullScreenSize.getWidth()/4,fullScreenSize.getHeight()/4));


    }

    @Test
    public void bounceTheWindow(){
        driver.manage().window().maximize();
        Dimension fullScreenSize = driver.manage().window().getSize();
        Point pos =driver.manage().window().getPosition();
        driver.manage().window().setSize(new Dimension(20,20));
        driver.manage().window().setPosition(new Point(fullScreenSize.getWidth()/4,fullScreenSize.getHeight()/4));

        int changeWidth = fullScreenSize.getWidth();
        int changeHeight = fullScreenSize.getHeight();

        while(changeWidth > 100) {
            changeWidth = changeWidth - 50;
            if (changeHeight > 200)
                changeHeight = changeHeight - 50;

            driver.manage().window().setSize(new Dimension(changeWidth, changeHeight));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
        int xDir = 10;
        int yDir =10;

        Point position = driver.manage().window().getPosition();

        for(int bounceIterations = 0; bounceIterations<300; bounceIterations++){
            position = position.moveBy(xDir,yDir);
        }
    }
}