package com.github.ultram4rine.ssu.artnowtesting.pages;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BucketPage extends BasePage {
    public BucketPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check the arts is in the bucket")
    public Boolean checkBucketItems(List<Art> items) {
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#main_container > div.c_row"));
        for (Integer i = 0; i < items.size(); i++) {
            if (artList.size() != items.size()) {
                return false;
            }

            String name = artList.get(i).findElement(By.cssSelector(".c_cell > :nth-child(1)")).getText();
            String price = artList.get(i).findElement(By.cssSelector(".c_cell > .shop > .price")).getText();

            if (name != items.get(i).getName() || price != items.get(i).getPrice()) {
                return false;
            }
        }
        return true;
    }
}
