package com.github.ultram4rine.ssu.artnowtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
    private static final int DEFAULT_TIME = 1000;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    protected void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void timeSleep() {
        try {
            Thread.sleep(DEFAULT_TIME);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
