package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import com.seleniumsimplified.junit.navigation.pages.BasicAjaxPageObject;
import com.seleniumsimplified.junit.navigation.pages.ProcessedFormPage;
import org.junit.Before;
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
import static com.seleniumsimplified.junit.navigation.pages.BasicAjaxPageObject.Category;
import static com.seleniumsimplified.junit.navigation.pages.BasicAjaxPageObject.Language;

public class SynchronisationCustomWaitRefactorTest {

    private static WebDriver driver;
    private BasicAjaxPageObject basicAjaxPage;


    @Before
    public void setupTest(){
        driver = Driver.get();
        basicAjaxPage = new BasicAjaxPageObject(driver);
        basicAjaxPage.get();
    }

    @Test
    public void assertTitle(){
        String ogTitle = driver.getTitle();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String newTitle = driver.getTitle();
        assertThat(ogTitle, is(not(newTitle)));
    }

    @Test
    public void selectServerJAVA(){

        basicAjaxPage.selectCategory(Category.SERVER);

        basicAjaxPage.selectLanguage(Language.JAVA);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.get();

        assertEquals("Expected Java code", "23", processedFormPage.getValueFor("language_id"));


    }
    @Test
    public void selectServerCobol(){

        basicAjaxPage.selectCategory(Category.SERVER);

        basicAjaxPage.selectLanguage(Language.COBOL);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.get();

        assertEquals("Expected Java code", "20", processedFormPage.getValueFor("language_id"));


    }

    @Test
    public void selectWebVB() {

        basicAjaxPage.selectCategory(Category.SERVER);
        basicAjaxPage.selectCategory(Category.WEB);

        basicAjaxPage.selectLanguage(Language.VBSCRIPT);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.get();

        assertEquals("Expected Javascript code", "1", processedFormPage.getValueFor("language_id"));

    }
    @Test
    public void selectWebJavaScript() {

        basicAjaxPage.selectCategory(Category.SERVER);
        basicAjaxPage.selectCategory(Category.WEB);

        basicAjaxPage.selectLanguage(Language.JAVASCRIPT);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.get();

        assertEquals("Expected Javascript code", "0", processedFormPage.getValueFor("language_id"));

    }
    @Test
    public void selectDesktop(){
        basicAjaxPage.selectCategory(Category.DESKTOP);

        basicAjaxPage.selectLanguage(Language.C);
        basicAjaxPage.clickCodeInIt();

        ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
        processedFormPage.get();

        assertEquals("Expected C code", "12", processedFormPage.getValueFor("language_id"));

    }


}
