package com.github.ultram4rine.ssu.artnowtesting.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;
    private static String browserType = null;

    public Properties initProp() {
        prop = new Properties();
        try {
            FileInputStream inp = new FileInputStream("./src/main/resources/application.properties");
            prop.load(inp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBrowserType(prop.getProperty("browser"));
        return prop;
    }

    public static void setBrowserType(String browser) {
        browserType = browser;
    }

    public static String getBrowserType() throws Throwable {
        if (browserType != null) {
            return browserType;
        } else {
            throw new RuntimeException("browser not specified in testng.xml");
        }
    }
}
