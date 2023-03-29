package com.github.ultram4rine.ssu.artnowtesting.pages;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Show more genres")
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
    public Boolean checkArtPresent(String artName) {
        timeSleep();
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        for (WebElement el : artList) {
            WebElement name = getDriver().findElement(By.cssSelector("#sa_container > div:nth-child(5) > a > div"));
            if (name.getText().contains(artName)) {
                return true;
            }
        }
        return false;
    }

    @Step("Click on item by name")
    public void clickOnArtByName(String artName) {
        timeSleep();
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
    public void clickOnArtByNumber(Integer number) {
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > .post"));
        WebElement art = artList.get(number);
        waitForElementClickable(art);
        art.click();
    }

    @Step("Choose first n items")
    public List<Art> addFirstNToBucket(Integer n) {
        List<Art> items = new ArrayList<Art>();
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#sa_container > .post"));
        for (Integer i = 0; i < n; i++) {
            String desc = artList.get(i).findElement(By.cssSelector(".ssize")).getText();
            String price = artList.get(i).findElement(By.cssSelector(".price")).getText();
            WebElement btn = artList.get(i).findElement(By.cssSelector(".oclick"));
            waitForElementClickable(btn);
            btn.click();
            items.add(new Art(desc, desc, price));
            WebElement btnContinue = getDriver().findElement(By.cssSelector("#cmodal > div > p > button.continue"));
            waitForElementClickable(btnContinue);
            btnContinue.click();
        }
        return items;
    }

    @Step("Go to bucket")
    public void goToBucket() {
        WebElement bucket = getDriver().findElement(By.cssSelector("body > div.topheader > span.basketico"));
        waitForElementClickable(bucket);
        bucket.click();
    }
}
