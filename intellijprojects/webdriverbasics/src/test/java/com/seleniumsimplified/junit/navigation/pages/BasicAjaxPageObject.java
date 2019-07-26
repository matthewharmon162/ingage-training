package com.seleniumsimplified.junit.navigation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;



public class BasicAjaxPageObject extends LoadableComponent <BasicAjaxPageObject>{
    WebDriver driver;

    @FindBy(how= How.ID, using="combo1")
    private WebElement categorySelect;

    @FindBy(how= How.ID, using="combo2")
    private WebElement languageSelect;

    @FindBy(how= How.NAME, using="submitbutton")
    private WebElement codeInIt;

    public enum Category{

        SERVER(3), WEB(1), DESKTOP(2);

        private int dropDownValue;

        Category(int value){
            this.dropDownValue = value;
        }
        public int value(){
            return dropDownValue;
        }
    }
    public enum Language{
        JAVA(23), JAVASCRIPT(0), C(12), VBSCRIPT(1), COBOL(20);

        private int dropDownValue;

        Language(int value){
            this.dropDownValue = value;
        }
        public int value(){
            return dropDownValue;
        }
    }
    public BasicAjaxPageObject(WebDriver aDriver){
        driver = aDriver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load(){
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }
    @Override
    protected void isLoaded() throws Error{
        try {
            categorySelect.isDisplayed();
        }catch(NoSuchElementException e){
            throw new Error("basic_ajax page not loaded");
        }
    }

    public void selectCategory(Category category) {
        categorySelect.findElement(By.cssSelector("option[value ='" + category.value() + "']")).click();
        new WebDriverWait(driver,10).until(ajaxActionIsComplete());
    }

    public ExpectedCondition<Boolean> ajaxActionIsComplete() {
        return ExpectedConditions.invisibilityOfElementLocated(
                By.id("ajaxBusy"));


    }

    public void selectLanguage(Language Language) {
        languageSelect.findElement(By.cssSelector("#combo2 >option[value='"+ Language.value() + "']")).click();


    }

    public void clickCodeInIt() {

        codeInIt.click();

    }
}
