package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class InteractionExercisesTest {

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

        driver.navigate().to(ROOT_URL + "/selenium/basic_html_form.html");
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

       // new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed From Details"));
        String text = driver.findElement(By.cssSelector("li[id='_valuecomments']")).getText();
        assertEquals("Hello World", text);
    }

    @Test
    public void radio2Selected(){
        driver.findElement(By.cssSelector("input[value='rd3']")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String text = driver.findElement(By.cssSelector("li[id='_valueradioval']")).getText();
        assertEquals("rd3", text);
    }

    @Test
    public void checkbox1Only() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='cb2']"));
        WebElement checkbox3 = driver.findElement(By.cssSelector("input[value='cb3']"));
        if(!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if(checkbox2.isSelected()) {
            checkbox2.click();
        }
        if(checkbox3.isSelected()) {
            checkbox3.click();
        }
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String text = driver.findElement(By.cssSelector("li[id='_valuecheckboxes0']")).getText();
        assertEquals("cb1", text);
        WebElement checkbox2Result = null;
        WebElement checkbox3Result = null;
        try{
         checkbox2Result = driver.findElement(By.cssSelector("li[id='_valuecheckboxes1']"));
        }catch (NoSuchElementException e){

        }
        try{
            checkbox3Result = driver.findElement(By.cssSelector("li[id='_valuecheckboxes2']"));
        }catch (NoSuchElementException e){

        }
        assertTrue(checkbox2Result==null);
        assertTrue(checkbox3Result==null);
    }

    @Test
    public void dropDown5(){
        WebElement dropDownSelect;
        WebElement dropDownOption;

        dropDownSelect= driver.findElement(By.cssSelector("select[name='dropdown']"));
        dropDownOption =dropDownSelect.findElement(By.cssSelector("option[value='dd5']"));
        dropDownOption.click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String text = driver.findElement(By.cssSelector("li[id='_valuedropdown']")).getText();
        assertEquals("dd5", text);
    }

    @Test
    public void multipleSelect(){
        WebElement multiSelect;
        WebElement dropDownOption;

        multiSelect= driver.findElement(By.cssSelector("select[multiple='multiple']"));
        List<WebElement> multiSelectOptions = multiSelect.findElements(By.tagName("option"));
        multiSelectOptions.get(0).click();
        multiSelectOptions.get(1).click();
        multiSelectOptions.get(2).click();
        if(multiSelectOptions.get(3).isSelected()){
            multiSelectOptions.get(3).click();
        }
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assertEquals("ms1", driver.findElement(By.id("_valuemultipleselect0")).getText());
        assertEquals("ms2", driver.findElement(By.id("_valuemultipleselect1")).getText());
        assertEquals("ms3", driver.findElement(By.id("_valuemultipleselect2")).getText());
        assertTrue( driver.findElements(By.id("_valuemultipleselect3")).isEmpty());
    }
    @Test
    public void uploadFile(){
      driver.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\Matt Harmon\\Pictures\\Saved Pictures\\Xpath&CSSselectors.pdf");

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        String text = driver.findElement(By.cssSelector("li[id='_valuefilename']")).getText();
        assertEquals("Xpath&CSSselectors.pdf", text);
    }

    @Test
    public void multipleSelectvV2(){
        WebElement multiSelectElement;

        multiSelectElement= driver.findElement(By.cssSelector("select[multiple='multiple']"));
        Select multipleSelect = new Select(multiSelectElement);
        assertTrue(multipleSelect.isMultiple());
        multipleSelect.deselectAll();
        multipleSelect.selectByVisibleText("Selectioin Item 1");
        multipleSelect.selectByIndex(1);
        multipleSelect.selectByValue("ms3");

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        assertEquals("ms1", driver.findElement(By.id("_valuemultipleselect0")).getText());
        assertEquals("ms2", driver.findElement(By.id("_valuemultipleselect1")).getText());
        assertEquals("ms3", driver.findElement(By.id("_valuemultipleselect2")).getText());
        assertTrue( driver.findElements(By.id("_valuemultipleselect3")).isEmpty());

    }
}
