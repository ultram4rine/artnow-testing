package com.github.ultram4rine.ssu.artnowtesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Click on art category 'show more' button")
    public void showMoreCategories() {
        WebElement showMoreButton = getDriver().findElement(By.cssSelector(".menu-group > div"));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
    }

    @Step("Click on art category menu item")
    public void chooseCategory(String category) {
        List<WebElement> menuItemList = getDriver()
                .findElements(By.cssSelector(".left_bar > .main_menu > :nth-child(2) > li"));
        for (WebElement el : menuItemList) {
            if (el.getText().contains(category)) {
                waitForElementClickable(el);
                el.click();
                break;
            }
        }
    }

    @Step("Input string to search")
    public void search(CharSequence name) {
        WebElement globalSearchInput = getDriver()
                .findElement(By.cssSelector("#MainSearchForm > div > div:nth-child(1) > input.inp.scLarge"));
        waitForElementClickable(globalSearchInput);
        globalSearchInput.sendKeys(name);
        WebElement globalSearchButton = getDriver()
                .findElement(By.cssSelector("#MainSearchForm > div > div:nth-child(2) > button"));
        waitForElementClickable(globalSearchButton);
        globalSearchButton.click();
    }
}
