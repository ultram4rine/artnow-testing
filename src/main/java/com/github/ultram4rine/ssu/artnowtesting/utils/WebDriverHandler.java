package com.github.ultram4rine.ssu.artnowtesting.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverHandler implements WebDriverListener {
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ScreenShotMaker.takeScreenShot();
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, java.lang.CharSequence[] keysToSend) {
        ScreenShotMaker.takeScreenShot();
    }
}
