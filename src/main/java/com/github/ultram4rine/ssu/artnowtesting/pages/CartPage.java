package com.github.ultram4rine.ssu.artnowtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    private String CART_ITEM_NAME_XPATH = "//*[@id=\"cart1100221\"]/div[3]/div[1]/a";
    private String CART_ITEM_AUTHOR_XPATH = "//*[@id=\"cart1100221\"]/div[3]/div[3]/a";
    private String CART_ITEM_PRICE_XPATH = "//*[@id=\"cart1100221\"]/div[3]/div[5]/div[2]";

    // TODO fix
    public void checkCartItemName(String name) {
        WebElement cartItemName = getDriver().findElement(By.xpath(CART_ITEM_NAME_XPATH));
        Assert.assertEquals(cartItemName.getText(), name);
    }

    public void checkCartItemAuthor(String author) {
        WebElement cartItemAuthor = getDriver().findElement(By.xpath(CART_ITEM_AUTHOR_XPATH));
        Assert.assertEquals(cartItemAuthor.getText(), author);
    }

    public void checkCartItemPrice(String price) {
        WebElement cartItemPrice = getDriver().findElement(By.xpath(CART_ITEM_PRICE_XPATH));
        Assert.assertEquals(cartItemPrice.getText(), price);
    }
}