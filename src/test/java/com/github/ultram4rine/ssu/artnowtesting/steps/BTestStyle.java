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
public class BTestStyle extends TestRunner {
    /**
     * 2.2
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", открыть подробности картины "Трамвайный путь",
     * проверить, что стиль картины "Реализм".
     */

    MainPage mainPage = new MainPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);
    CatalogItemPage catalogItemPage = new CatalogItemPage(driver);

    @When("again user goes to category Embroidered pictures")
    public void again_user_goes_to_category() {
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Вышитые картины");
    }

    @When("again user goes to genre City landscape")
    public void again_user_goes_to_genre_City_landscape() {
        CatalogPage catalogPage = new CatalogPage(driver);
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
