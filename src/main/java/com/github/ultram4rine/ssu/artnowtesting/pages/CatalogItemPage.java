package com.github.ultram4rine.ssu.artnowtesting.pages;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CatalogItemPage extends BasePage {
    public CatalogItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkStyle(String style) {
        WebElement styleLink = getDriver().findElement(
                By.cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div:nth-child(9) > a"));
        Assert.assertEquals(styleLink.getText(), style);
    }

    public Art addToFavorite() {
        WebElement addToFavoriteButton = getDriver()
                .findElement(By
                        .cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > span"));
        waitForElementClickable(addToFavoriteButton);
        addToFavoriteButton.click();
        return new Art(getArtName(), getArtAuthor(), "");
    }

    public void checkFavoriteCount(int count) {
        WebElement favoriteCounter = getDriver().findElement(By.cssSelector("#FvtCnt"));
        waitForElementVisible(favoriteCounter);
        Assert.assertEquals(Integer.parseInt(favoriteCounter.getText()), count);
    }

    public void goToFavorites() {
        WebElement favoriteIcon = getDriver().findElement(By.cssSelector("body > div.topheader > span.fvtico"));
        waitForElementClickable(favoriteIcon);
        favoriteIcon.click();
    }

    public void checkArtNameContains(String str) {
        Assert.assertTrue(getArtName().toLowerCase().contains(str.toLowerCase()));
    }

    public String getArtName() {
        return getDriver().findElement(By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > h1"))
                .getText();
    }

    public String getArtAuthor() {
        return getDriver()
                .findElement(
                        By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > div:nth-child(3) > a"))
                .getText();
    }

    public String getArtPrice() {
        return getDriver().findElement(By.cssSelector(
                "#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > div:nth-child(4) > b:nth-child(2)"))
                .getText();
    }

    public Art addToBucket() {
        WebElement addToCartButton = getDriver().findElement(By.cssSelector("#CartButton1100221"));
        waitForElementClickable(addToCartButton);
        addToCartButton.click();
        return new Art(getArtName(), getArtAuthor(), getArtPrice());
    }

    public void goToBucket() {
        WebElement btn = getDriver().findElement(By.cssSelector("#cmodal > div > p > button.ok-button"));
        waitForElementVisible(btn);
        waitForElementClickable(btn);
        btn.click();
    }
}
