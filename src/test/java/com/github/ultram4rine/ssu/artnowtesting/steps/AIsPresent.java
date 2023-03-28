package com.github.ultram4rine.ssu.artnowtesting.steps;

import com.github.ultram4rine.ssu.artnowtesting.TestRunner;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.FailedTestListener;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners({ FailedTestListener.class })
public class AIsPresent extends TestRunner {
    /**
     * 2.1
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", проверить, что картина "Трамвайный путь"
     * присутствует в выдаче.
     */

    MainPage mainPage = new MainPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);

    @When("user goes to category Embroidered pictures")
    public void user_goes_to_category() {
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
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.showMoreGenres();
        catalogPage.chooseGenre("Городской пейзаж");
    }

    @Then("art Tram way is present")
    public void art_Tram_way_is_present() {
        Assert.assertTrue(catalogPage.checkArtPresent("Трамвайный путь"));
    }
}
