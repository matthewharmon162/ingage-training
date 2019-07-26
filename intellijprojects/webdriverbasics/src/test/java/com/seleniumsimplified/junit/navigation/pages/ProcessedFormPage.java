package com.seleniumsimplified.junit.navigation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessedFormPage extends SlowLoadableComponent<ProcessedFormPage> {
    private WebDriver driver;

    public ProcessedFormPage (WebDriver aDriver){
        super(new SystemClock(), 10);
        driver = aDriver;

    }



    public  String getValueFor(String valueId) {

        WebElement fieldValueElement = driver.findElement(By.id("_value" + valueId));
        return fieldValueElement.getText();
    }
    @Override
    protected  void load(){

    }
    @Override
    protected void isLoaded() throws Error{
        if(!driver.getTitle().contentEquals("Processed Form Details")){
            throw new Error("Title was not 'Processed Form Details' it was " + driver.getTitle());
        }
    }
}
