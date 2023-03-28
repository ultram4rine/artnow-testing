package com.github.ultram4rine.ssu.artnowtesting.pages;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogItemPage extends BasePage {
    public CatalogItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check style of art")
    public Boolean checkStyle(String style) {
        WebElement styleEl = getDriver().findElement(
                By.cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div:nth-child(9) > a"));
        return styleEl.getText().equals(style);
    }

    @Step("Add art to favorites")
    public Art addToFavorite() {
        WebElement addToFavoriteButton = getDriver()
                .findElement(By
                        .cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > span"));
        waitForElementClickable(addToFavoriteButton);
        addToFavoriteButton.click();
        return new Art(getArtName(), getArtAuthor(), "");
    }

    @Step("Check favorites count")
    public Boolean checkFavoriteCount(int count) {
        WebElement favoriteCounter = getDriver().findElement(By.cssSelector("#FvtCnt"));
        waitForElementVisible(favoriteCounter);
        return Integer.parseInt(favoriteCounter.getText()) == count;
    }

    @Step("Go to favorites page")
    public void goToFavorites() {
        WebElement favoriteIcon = getDriver().findElement(By.cssSelector("body > div.topheader > span.fvtico"));
        waitForElementClickable(favoriteIcon);
        favoriteIcon.click();
    }

    @Step("Check that art name contains string")
    public Boolean checkArtNameContains(String str) {
        return getArtName().toLowerCase().contains(str.toLowerCase());
    }

    @Step("Get the name of the art")
    public String getArtName() {
        return getDriver().findElement(By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > h1"))
                .getText();
    }

    @Step("Get the author of the art")
    public String getArtAuthor() {
        return getDriver()
                .findElement(
                        By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > div:nth-child(3) > a"))
                .getText();
    }

    @Step("Get the price of the art")
    public String getArtPrice() {
        return getDriver().findElement(By.cssSelector(
                "#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > div:nth-child(4) > b:nth-child(2)"))
                .getText();
    }

    @Step("Add art to the bucket")
    public void addToBucket() {
        WebElement addToCartButton = getDriver().findElement(By.cssSelector("#CartButton1100221"));
        waitForElementClickable(addToCartButton);
        addToCartButton.click();
    }

    @Step("Go to the bucket")
    public void goToBucket() {
        WebElement btn = getDriver().findElement(By.cssSelector("#cmodal > div > p > button.ok-button"));
        waitForElementVisible(btn);
        waitForElementClickable(btn);
        btn.click();
    }
}
