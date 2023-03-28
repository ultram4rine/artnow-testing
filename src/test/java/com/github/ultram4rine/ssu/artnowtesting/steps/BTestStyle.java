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
public class BTestStyle {
    private Scenario scenario;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

    /**
     * 2.2
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", открыть подробности картины "Трамвайный путь",
     * проверить, что стиль картины "Реализм".
     */

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    CatalogPage catalogPage = new CatalogPage(DriverFactory.getDriver());
    CatalogItemPage catalogItemPage = new CatalogItemPage(DriverFactory.getDriver());

    @When("again user goes to category Embroidered pictures")
    public void again_user_goes_to_category() {
        DriverFactory.getDriver().get("https://artnow.ru");
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Вышитые картины");
    }

    @When("again user goes to genre City landscape")
    public void again_user_goes_to_genre_City_landscape() {
        catalogPage.showMoreGenres();
        catalogPage.chooseGenre("Городской пейзаж");
    }

    @When("user goes to art Tram way")
    public void user_goes_to_art_Tram_way() {
        catalogPage.clickOnArtByName("Трамвайный путь");
    }

    @Then("art Tram way style is reality")
    public void art_Tram_way_style_is_reality() {
        Assert.assertTrue(catalogItemPage.checkStyle("Реализм"));
    }
}
