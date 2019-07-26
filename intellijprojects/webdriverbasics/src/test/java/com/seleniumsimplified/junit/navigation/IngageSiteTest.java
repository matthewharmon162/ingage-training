package com.seleniumsimplified.junit.navigation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IngageSiteTest {


    @Test
    public void basicChromeUsage() throws InterruptedException {
        WebDriver firefox = new FirefoxDriver();
        firefox.get("http://www.ingagepartners.com/");

        firefox.findElement(By.cssSelector("#menu-item-3384 > a:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(firefox, 10 );
        Thread.sleep(2000);
     //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fws_5d15681ea56a5\"]/div[2]/div[2]/div[2]/div/a")));
        firefox.findElement(By.xpath("//*[@id=\"fws_5d15681ea56a5\"]/div[2]/div[2]/div[2]/div/a")).click();



    }

}

