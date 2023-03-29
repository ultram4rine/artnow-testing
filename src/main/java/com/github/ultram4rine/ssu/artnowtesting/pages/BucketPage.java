package com.github.ultram4rine.ssu.artnowtesting.pages;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BucketPage extends BasePage {
    public BucketPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check the arts is in the bucket")
    public Boolean checkBucketItems(List<Art> items) {
        List<Boolean> oks = new ArrayList<Boolean>();
        List<WebElement> artList = getDriver().findElements(By.cssSelector("#main_container > div.c_row"));
        if (artList.size() != items.size()) {
            return false;
        }

        elLoop: for (WebElement el : artList) {
            String name = el.findElement(By.cssSelector(".c_cell > :nth-child(1)")).getText();
            String price = el.findElement(By.cssSelector(".c_cell > .shop > .price")).getText();
            for (Art a : items) {
                if (a.getName().contains(name) || a.getPrice().equals(price)) {
                    oks.add(true);
                    continue elLoop;
                }
            }
            oks.add(false);
        }
        for (Boolean ok : oks) {
            if (!ok) {
                return false;
            }
            return true;
        }
        return false;
    }
}
