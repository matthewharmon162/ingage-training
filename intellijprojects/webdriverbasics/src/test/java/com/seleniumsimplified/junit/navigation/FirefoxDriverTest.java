package com.seleniumsimplified.junit.navigation;

import com.seleniumsimplified.junit.Driver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;



public class FirefoxDriverTest {
    @BeforeClass
    public static void setupTheFirefoxDriverSystemProperty(){

    }
    @Test
    public void basicFirefoxUsage(){

        WebDriver gecko = new FirefoxDriver();

        gecko.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        assertThat(gecko.getTitle(), is("Basic Ajax"));
        gecko.quit();
    }

//    @Test
//    public void firefoxDriverWithProfile(){
//
//        FirefoxProfile profile = new FirefoxProfile();
//     //   profile.setEnabledNativeEvents(true);
//
//        WebDriver firefox = new FirefoxDriver((Capabilities) profile);
//
//        firefox.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
//
//        assertThat(firefox.getTitle(), is ("HTML Form Elements"));
//
//        firefox.quit();
//    }

    @Test public void firefoxDriverWithCapabilitiesForProxy(){

        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(Driver.PROXY)
                .setFtpProxy(Driver.PROXY)
                .setSslProxy(Driver.PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver gecko = new FirefoxDriver();

        gecko.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        assertThat(gecko.getTitle(), is("Basic Ajax"));
        gecko.quit();

    }
}