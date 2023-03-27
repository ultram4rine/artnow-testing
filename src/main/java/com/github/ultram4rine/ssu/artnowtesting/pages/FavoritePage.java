package com.github.ultram4rine.ssu.artnowtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FavoritePage extends BasePage {
    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isInFavorites(String name, String author) {
        List<WebElement> favorites = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        Boolean isItemPresent = false;
        for (WebElement el : favorites) {
            WebElement authorAndName = el.findElement(By.cssSelector("div"));
            String txt = authorAndName.getText();
            if (txt.contains(name) && txt.contains(author)) {
                isItemPresent = true;
                break;
            }
        }
        Assert.assertTrue(isItemPresent);
    }
}
