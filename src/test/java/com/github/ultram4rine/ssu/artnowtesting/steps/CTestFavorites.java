package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.models.Art;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogItemPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.FavoritePage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.DriverFactory;

import lombok.extern.slf4j.Slf4j;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

@Slf4j
public class CTestFavorites {
    private Scenario scenario;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

    /**
     * 2.3
     * Перейти в “Батик”, добавить первую картину в избранное, проверить,
     * что выбранная картина сохранилась в разделе «Избранное».
     */

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    CatalogPage catalogPage = new CatalogPage(DriverFactory.getDriver());
    CatalogItemPage catalogItemPage = new CatalogItemPage(DriverFactory.getDriver());
    FavoritePage favoritePage = new FavoritePage(DriverFactory.getDriver());

    Art art = null;

    @When("user goes to category Batik")
    public void user_goes_to_category_Batik() {
        DriverFactory.getDriver().get("https://artnow.ru");
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Батик");
    }

    @When("user adds first art to favorites")
    public void user_adds_first_art_to_favorites() {
        catalogPage.clickOnArtByNumber(0);
        art = catalogItemPage.addToFavorite();
    }

    @Then("favorites count is one")
    public void favorites_count_is_one() {
        Assert.assertTrue(catalogItemPage.checkFavoriteCount(1));
    }

    @When("user goes to favorites")
    public void user_goes_to_favorites() {
        catalogItemPage.goToFavorites();
    }

    @Then("art is in favorites")
    public void art_is_in_favorites() {
        Assert.assertTrue(favoritePage.isInFavorites(art.getName(), art.getAuthor()));
    }
}
