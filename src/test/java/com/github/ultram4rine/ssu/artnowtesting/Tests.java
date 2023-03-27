package com.github.ultram4rine.ssu.artnowtesting;

import com.github.ultram4rine.ssu.artnowtesting.conf.Conf;
import com.github.ultram4rine.ssu.artnowtesting.models.Art;
import com.github.ultram4rine.ssu.artnowtesting.pages.BucketPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogItemPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.CatalogPage;
import com.github.ultram4rine.ssu.artnowtesting.pages.FavoritePage;
import com.github.ultram4rine.ssu.artnowtesting.pages.MainPage;
import com.github.ultram4rine.ssu.artnowtesting.utils.FailedTestListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ FailedTestListener.class })
public class Tests extends Conf {
    /**
     * 2.1
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", проверить, что картина "Трамвайный путь"
     * присутствует в выдаче.
     */
    @Test
    public void testIsPresent() {
        MainPage mainPage = new MainPage(driver);
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.showMoreGenres();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkArtPresent("Трамвайный путь");
    }

    /**
     * 2.2
     * Перейти в "Вышитые картины", произвести поиск по жанру
     * "Городской пейзаж", открыть подробности картины "Трамвайный путь",
     * проверить, что стиль картины "Реализм".
     */
    @Test
    public void testStyle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.showMoreGenres();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkArtPresent("Трамвайный путь");
        catalogPage.clickOnArtByName("Трамвайный путь");
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkStyle("Реализм");
    }

    /**
     * 2.3
     * Перейти в “Батик”, добавить первую картину в избранное, проверить,
     * что выбранная картина сохранилась в разделе «Избранное».
     */
    @Test
    public void testFavorite() {
        MainPage mainPage = new MainPage(driver);
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Батик");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnArtByNumber(0);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        Art art = catalogItemPage.addToFavorite();
        catalogItemPage.checkFavoriteCount(1);
        catalogItemPage.goToFavorites();
        FavoritePage favoritePage = new FavoritePage(driver);
        favoritePage.isInFavorites(art.getName(), art.getAuthor());
    }

    /**
     * 2.4
     * Ввести в поисковую строку «Жираф», проверить, что название первой картины
     * содержит слово «Жираф».
     */
    @Test
    public void testSearch() {
        MainPage mainPage = new MainPage(driver);
        mainPage.search("Жираф");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnArtByNumber(0);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkArtNameContains("Жираф");
    }

    /**
     * 2.5
     * Перейти в "Ювелирное искусство", добавить первое изделие в
     * корзину, проверить, что выбранный товар находится в корзине, стоимость
     * товара не изменилась.
     */
    @Test
    public void testBucket() {
        MainPage mainPage = new MainPage(driver);
        mainPage.showMoreCategories();
        mainPage.chooseCategory("Ювелирное искусство");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnArtByNumber(0);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        String catalogItemName = catalogItemPage.getArtName();
        String catalogItemPrice = catalogItemPage.getArtPrice();
        catalogItemPage.addToBucket();
        catalogItemPage.goToBucket();
        BucketPage cartPage = new BucketPage(driver);
        cartPage.checkCartItemName(catalogItemName);
        cartPage.checkCartItemPrice(catalogItemPrice);
    }
}
