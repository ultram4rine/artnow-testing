package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.pages.BucketPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogItemPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.DriverFactory;

import lombok.extern.slf4j.Slf4j;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

@Slf4j
public class ETestBucket {
    private Scenario scenario;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

    /**
     * 2.5
     * Перейти в "Ювелирное искусство", добавить первое изделие в
     * корзину, проверить, что выбранный товар находится в корзине, стоимость
     * товара не изменилась.
     */

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    CatalogPage catalogPage = new CatalogPage(DriverFactory.getDriver());
    CatalogItemPage catalogItemPage = new CatalogItemPage(DriverFactory.getDriver());
    BucketPage bucketPage = new BucketPage(DriverFactory.getDriver());

    String catalogItemName = "";
    String catalogItemPrice = "";

    @When("user goes to the jewerly")
    public void user_goes_to_the_jewerly() {
        DriverFactory.getDriver().get("https://artnow.ru");
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
