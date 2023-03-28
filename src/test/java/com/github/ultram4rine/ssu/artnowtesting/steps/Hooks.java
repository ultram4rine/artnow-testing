package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.utils.ConfigReader;
import com.github.ultram4rine.ssu.artnowtesting.utils.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class Hooks {
    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {
        String browserName = "";
        try {
            browserName = ConfigReader.getBrowserType();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDrivers(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", name);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        }
    }
}
