package com.github.ultram4rine.ssu.artnowtesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Show more")
    public void showMoreGenres() {
        WebElement showMoreButton = getDriver()
                .findElement(By.cssSelector("#genrebox > span.dot.control.float-l.showextra > span.openclose"));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
    }

    @Step("Choose genre")
    public void chooseGenre(String genre) {
        List<WebElement> genreItemList = getDriver()
                .findElements(By.cssSelector("#genrebox > div > label"));
        for (WebElement el : genreItemList) {
            if (el.getText().contains(genre)) {
                waitForElementClickable(el);
                el.click();
                break;
            }
        }
        WebElement applyGenreButton = getDriver().findElement(By.cssSelector("#applymsg"));
        waitForElementClickable(applyGenreButton);
        applyGenreButton.click();
    }

    @Step("Check name")
    public void checkArtPresent(String artName) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        Boolean isPresent = false;
        for (WebElement el : artList) {
            WebElement name = getDriver().findElement(By.cssSelector("#sa_container > div:nth-child(5) > a > div"));
            if (name.getText().contains(artName)) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
    }

    @Step("Click on item by name")
    public void clickOnArtByName(String artName) {
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        for (WebElement el : artList) {
            WebElement name = getDriver().findElement(By.cssSelector("#sa_container > div:nth-child(5) > a > div"));
            if (name.getText().contains(artName)) {
                waitForElementClickable(name);
                name.click();
                break;
            }
        }
    }

    @Step("Click on item by number")
    public void clickOnArtByNumber(int number) {
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > .post"));
        WebElement art = artList.get(number);
        waitForElementClickable(art);
        art.click();
    }
}
