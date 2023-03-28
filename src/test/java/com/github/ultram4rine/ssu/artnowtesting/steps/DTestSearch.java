package com.github.ultram4rine.ssu.artnowtesting.steps;

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
public class DTestSearch {
    private Scenario scenario;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

    /**
     * 2.4
     * Ввести в поисковую строку «Жираф», проверить, что название первой картины
     * содержит слово «Жираф».
     */

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    CatalogPage catalogPage = new CatalogPage(DriverFactory.getDriver());
    CatalogItemPage catalogItemPage = new CatalogItemPage(DriverFactory.getDriver());

    @When("user searches for giraffe")
    public void user_searches_for_giraffe() {
        DriverFactory.getDriver().get("https://artnow.ru");
        mainPage.search("Жираф");
    }

    @When("user goes to the first result")
    public void user_goes_to_the_first_result() {
        catalogPage.clickOnArtByNumber(0);
    }

    @Then("art name contains giraffe")
    public void art_name_contains_giraffe() {
        Assert.assertTrue(catalogItemPage.checkArtNameContains("Жираф"));
    }
}
