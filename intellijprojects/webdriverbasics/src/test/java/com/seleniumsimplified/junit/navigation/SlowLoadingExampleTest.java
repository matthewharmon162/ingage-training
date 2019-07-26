package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.navigation.pages.IsLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public class SlowLoadingExampleTest extends SlowLoadableComponent<SlowLoadingExampleTest> {
    private final WebDriver driver;

    By SEND_BUTTON = By.cssSelector("div#content > form > input[type='button']");
    By NAME_FIELD = By.cssSelector("div#content > form > input[type='text']:nth-of-type(1)");
    By EMAIL_FIELD = By.cssSelector("div#content > form > input[type='text']:nth-of-type(2)");
    By MESSAGE = By.cssSelector("div#content > form > textarea");

    public SlowLoadingExampleTest(WebDriver driver){
        super(new SystemClock(), 10);
        this.driver = driver;

    }

    @Override
    protected void load(){
        driver.get("http://www.queness.com/resources/html/ajax/simple.php#page4");
    }

    @Override
    protected void isLoaded() throws Error {

        IsLoaded.forThis(driver).
                whenElementIsVisible(SEND_BUTTON, "Send Button").
                whenElementIsEnabled(SEND_BUTTON, "Send Button").
                whenElementIsVisible(NAME_FIELD, "Name Input").
                whenElementIsVisible(NAME_FIELD, "Name Input");

    }


    public SlowLoadingExampleTest setName(String name){
        driver.findElement(NAME_FIELD).sendKeys(name);
        return this;
    }

    public SlowLoadingExampleTest setEmail(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public SlowLoadingExampleTest setMessage(String message){
        driver.findElement(MESSAGE).sendKeys(message);
        return this;
    }

    public SlowLoadingExampleTest sendMessage(){
        driver.findElement(SEND_BUTTON).click();
        return this;
    }
}
