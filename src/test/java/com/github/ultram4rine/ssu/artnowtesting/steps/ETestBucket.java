package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.TestRunner;
import com.github.ultram4rine.ssu.artnowtesting.pages.BucketPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogItemPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.FailedTestListener;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners({ FailedTestListener.class })
public class ETestBucket extends TestRunner {
    /**
     * 2.5
     * Перейти в "Ювелирное искусство", добавить первое изделие в
     * корзину, проверить, что выбранный товар находится в корзине, стоимость
     * товара не изменилась.
     */

    MainPage mainPage = new MainPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);
    CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
    BucketPage bucketPage = new BucketPage(driver);

    String catalogItemName = "";
    String catalogItemPrice = "";

    @When("user goes to the jewerly")
    public void user_goes_to_the_jewerly() {
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Ювелирное искусство");
    }

    @When("user goes to the first art")
    public void user_goes_to_the_first_art() {
        catalogPage.clickOnArtByNumber(0);
    }

    @When("user adds first art to the bucket")
    public void user_adds_first_art_to_the_bucket() {
        catalogItemName = catalogItemPage.getArtName();
        catalogItemPrice = catalogItemPage.getArtPrice();
        catalogItemPage.addToBucket();
    }

    @When("user goes to the bucket")
    public void user_goes_to_the_bucket() {
        catalogItemPage.goToBucket();
    }

    @Then("art presented in the bucket")
    public void art_presented_in_the_bucket() {
        Assert.assertTrue(bucketPage.checkBucketItemName(catalogItemName));
        Assert.assertTrue(bucketPage.checkBucketItemPrice(catalogItemPrice));
    }
}
