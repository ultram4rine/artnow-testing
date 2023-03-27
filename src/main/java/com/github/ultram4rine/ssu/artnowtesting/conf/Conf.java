package com.github.ultram4rine.ssu.artnowtesting.conf;

import com.github.ultram4rine.ssu.artnowtesting.utils.BrowsersEnum;
import com.github.ultram4rine.ssu.artnowtesting.utils.WebDriverHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Conf {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Properties properties = new Properties();
    public static Duration webDriverWaitTimeout;

    public static final String ARTNOW_BASE_URL = "https://artnow.ru";
    public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String FIREFOX_DRIVER_PROPERTY = "webdriver.firefox.driver";

    static {
        try {
            properties.load(Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() throws IllegalArgumentException {
        BrowsersEnum browser = BrowsersEnum.valueOf(properties.getProperty("artnow-testing.browser"));
        if (browser.equals(BrowsersEnum.CHROME)) {
            System.setProperty(CHROME_DRIVER_PROPERTY, properties.getProperty("artnow-testing.driver.chrome"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        }
        if (browser.equals(BrowsersEnum.FIREFOX)) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY, properties.getProperty("artnow-testing.driver.firefox"));
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        WebDriverHandler handler = new WebDriverHandler();
        // driver.register(eventListener);
        webDriverWaitTimeout = Duration.parse(properties.getProperty("artnow-testing.webdriver-wait-timeout"));
        webDriverWait = new WebDriverWait(driver, webDriverWaitTimeout);
        driver.get(ARTNOW_BASE_URL);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
