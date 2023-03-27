package com.github.ultram4rine;

import com.github.ultram4rine.ssu.artnowtesting.conf.Conf;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.FailedTestListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ FailedTestListener.class })
public class FirstTest extends Conf {
    @Test
    public void checkTramTrack() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnGenreShowMoreButton();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkArtName("Трамвайный путь");
    }
}
