package com.github.ultram4rine.ssu.artnowtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BucketPage extends BasePage {
    public BucketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkCartItemName(String name) {
        WebElement cartItemName = getDriver().findElement(By.cssSelector(".c_name"));
        Assert.assertEquals(cartItemName.getText(), name);
    }

    public void checkCartItemPrice(String price) {
        WebElement cartItemPrice = getDriver().findElement(By.cssSelector(".price"));
        Assert.assertEquals(cartItemPrice.getText(), price);
    }
}
