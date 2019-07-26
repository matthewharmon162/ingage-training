package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class NavitigationExampleTest {

    private static WebDriver driver;
    final private String PROTOCOL = "http";
    final private String DOMAIN = "www.compendiumdev.co.uk";
    final private String ROOT_URL = PROTOCOL + "://" + DOMAIN;

    @BeforeClass
    public static void createDriver(){
        driver = Driver.get();
    }

    @Test
    public void navigateHome(){
        driver.navigate().to(ROOT_URL + "/selenium");
        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void navigateSearch(){
        driver.navigate().to(ROOT_URL + "/selenium/search.php");
        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void navigateBasicHtmlForm(){
        driver.navigate().to(ROOT_URL + "/selenium/basic_html_form.html");
        Assert.assertTrue(driver.getTitle().startsWith("HTML Form Elements"));
    }
    @Test
    public void navigateBasicWebPage(){
        driver.navigate().to(ROOT_URL + "/selenium/basic_web_page.html");

        Assert.assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));
    }

    @Test
    public void navigateRefresh() throws Exception {
        driver.navigate().to(ROOT_URL + "/selenium/refresh.php");
        int i = 0;
        while(i < 5) {
            String ORIGINALTITLE = driver.getTitle();
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
            String REFRESHEDTITLE = driver.getTitle();
            Assert.assertFalse(REFRESHEDTITLE.startsWith(ORIGINALTITLE));
            i++;
        }
    }
    @AfterClass
    public static void quitDriver(){
       // driver.quit();
    }
}
