package com.github.ultram4rine.ssu.artnowtesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritePage extends BasePage {
    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check that art is in favorites")
    public Boolean isInFavorites(String name, String author) {
        List<WebElement> favorites = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        for (WebElement el : favorites) {
            WebElement authorAndName = el.findElement(By.cssSelector("div"));
            String txt = authorAndName.getText();
            if (txt.contains(name) && txt.contains(author)) {
                return true;
            }
        }
        return false;
    }
}
