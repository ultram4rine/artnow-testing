package com.github.ultram4rine.ssu.artnowtesting.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initializeDrivers(String browser) {
        System.out.println("browser value is: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().browserVersion("110.0.0").setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            tlDriver.set(new ChromeDriver(chromeOptions));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            tlDriver.set(new FirefoxDriver(firefoxOptions));
        } else {
            System.out.println("pass the correct browser value");
        }

        getDriver().manage().window().maximize();
        getDriver().get("https://artnow.ru");
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
