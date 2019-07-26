package com.seleniumsimplified.junit.navigation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.List;

public class SelectContainsText implements ExpectedCondition<Boolean> {
    private String textToFind;
    private By findBy;

    public SelectContainsText(final By comboFindBy, final String textToFind){
        this.findBy = comboFindBy;
        this.textToFind = textToFind;
    }

    @Override
    public Boolean apply(WebDriver webDriver){
        WebElement combo = webDriver.findElement(this.findBy);
        List<WebElement> options = combo.findElements(By.tagName("option"));

        for(WebElement anOption : options){
            if(anOption.getText().equals(this.textToFind))
                return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return "select " + this.findBy + " to contain " + this.textToFind;
    }
}