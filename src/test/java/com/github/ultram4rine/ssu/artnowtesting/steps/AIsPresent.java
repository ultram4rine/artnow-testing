package com.github.ultram4rine.ssu.artnowtesting.steps;

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
public class AIsPresent {
    private Scenario scenario;

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

    /**
     * 2.1
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", проверить, что картина "Трамвайный путь"
     * присутствует в выдаче.
     */

    MainPage mainPage = new MainPage(DriverFactory.getDriver());
    CatalogPage catalogPage = new CatalogPage(DriverFactory.getDriver());

    @When("user goes to category Embroidered pictures")
    public void user_goes_to_category() {
        DriverFactory.getDriver().get("https://artnow.ru");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Вышитые картины");
    }

    @When("user goes to genre City landscape")
    public void user_goes_to_genre_City_landscape() {
        catalogPage.showMoreGenres();
        catalogPage.chooseGenre("Городской пейзаж");
    }

    @Then("art Tram way is present")
    public void art_Tram_way_is_present() {
        Assert.assertTrue(catalogPage.checkArtPresent("Трамвайный путь"));
    }
}
