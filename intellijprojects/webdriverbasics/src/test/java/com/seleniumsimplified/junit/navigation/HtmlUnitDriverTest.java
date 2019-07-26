package com.seleniumsimplified.junit.navigation;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HtmlUnitDriverTest {

    @Test
    public void htmlUnitDriverSetUp(){
        WebDriver htmlunit = new HtmlUnitDriver(BrowserVersion.CHROME);
        htmlunit.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        assertThat(htmlunit.getTitle(), is("Basic Ajax"));
        htmlunit.quit();

    }
}
