package com.github.ultram4rine.ssu.artnowtesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BucketPage extends BasePage {
    public BucketPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check the art name in the bucket")
    public Boolean checkBucketItemName(String name) {
        WebElement cartItemName = getDriver().findElement(By.cssSelector(".c_name"));
        return cartItemName.getText().equals(name);
    }

    @Step("Check the art price in the bucket")
    public Boolean checkBucketItemPrice(String price) {
        WebElement cartItemPrice = getDriver().findElement(By.cssSelector(".price"));
        return cartItemPrice.getText().equals(price);
    }
}
