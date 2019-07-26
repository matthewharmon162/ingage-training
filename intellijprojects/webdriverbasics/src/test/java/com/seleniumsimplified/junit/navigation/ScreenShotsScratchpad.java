package com.seleniumsimplified.junit.navigation;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ScreenShotsScratchpad {

    @Test
    public void gotoPage() throws IOException{

        WebDriver driver = new FirefoxDriver();
        driver.get("https://seleniumsimplified.com");

        TakesScreenshot snapper = (TakesScreenshot)driver;

        File tempScreenshot = snapper.getScreenshotAs(OutputType.FILE);

        System.out.println(tempScreenshot.getAbsolutePath());

        File myScreenshotDirectory = new File ("c:\\temp\\screenshots\\");
        myScreenshotDirectory.mkdirs();

        File myScreenshot = new File(myScreenshotDirectory, "gotoPageScreen.png");
        FileUtils.moveFile(tempScreenshot, myScreenshot);

        assertThat(myScreenshot.length(), is(greaterThan(0L)));

        driver.get("file://" + myScreenshot.getAbsolutePath());
    }
}
