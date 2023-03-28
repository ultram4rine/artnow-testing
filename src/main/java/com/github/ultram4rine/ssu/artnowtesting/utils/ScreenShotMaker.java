package com.github.ultram4rine.ssu.artnowtesting.utils;

import com.github.ultram4rine.ssu.artnowtesting.pages.BasePage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotMaker {
    public static String today() {
        SimpleDateFormat timeScreen = new SimpleDateFormat("dd.MM.yyyy 'at' hh.mm.ss");
        return timeScreen.format(new Date());
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] takeScreenShot() {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
