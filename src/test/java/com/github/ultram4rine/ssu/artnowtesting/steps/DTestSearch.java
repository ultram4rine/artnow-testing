package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.TestRunner;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogItemPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.FailedTestListener;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners({ FailedTestListener.class })
public class DTestSearch extends TestRunner {
    /**
     * 2.4
     * Ввести в поисковую строку «Жираф», проверить, что название первой картины
     * содержит слово «Жираф».
     */

    MainPage mainPage = new MainPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);
    CatalogItemPage catalogItemPage = new CatalogItemPage(driver);

    @When("user searches for giraffe")
    public void user_searches_for_giraffe() {
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
