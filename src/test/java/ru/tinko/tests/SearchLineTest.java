package ru.tinko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tinko.pages.SearchPage;
import ru.tinko.pages.SearchResultsPage;

import static io.qameta.allure.Allure.step;

@Epic("Tinko UiTests")
@Feature("Search_2.0")
@Owner("s.zubakha")
@Severity(SeverityLevel.CRITICAL)
public class SearchLineTest extends TestBase {
    private String product1 = "Молния-12";
    private String product2 = "Маяк-220-С";
    private String invalidProduct = "whereIsMyGoods";
    SearchPage search = new SearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка строки поиска на главной")
    void searchLineInMainPageTest() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Ввод в строку поиска названия товара1", () ->
                search.enterValueInSearchInput(product1));
        step("Проверка отображения товара1 в подсказках", () ->
                search.checkSuggest(product1));
    }

    @Test
    @DisplayName("Проверка строки поиска на странице search/")
    void searchLineInSearchPageTest() {
        step("Открытие страницы search/", () ->
                search.openSearchPage());
        step("Ввод в строку поиска названия товара1", () ->
                search.enterValueInSearchInput(product1));
        step("Проверка отображения товара1 в подсказках", () ->
                search.checkSuggest(product1));
        step("Клик на иконку поиска", () ->
                search.clickSubmitIcon());
        step("Проверка заголовков страницы", () ->
                searchResultsPage.checkTitles(product1));
        step("Проверка отображения товара1 в первом результате выдачи", () ->
                searchResultsPage.checkFirstResult(product1));
    }

    @Test
    @DisplayName("Отображение всех результатов поиска")
    void showAllResultsInSuggestTest() {
        step("Открытие страницы search/", () ->
                search.openSearchPage());
        step("Ввод в строку поиска названия товара1", () ->
                search.enterValueInSearchInput(product1));
        step("Проверка отображения товара1 в подсказках", () ->
                search.checkSuggest(product1));
        step("Клик на кнопку показать все результаты", () ->
                search.clickShowAllResults());
        step("Проверка заголовков страницы", () ->
                searchResultsPage.checkTitles(product1));
        step("Проверка отображения товара1 в первом результате выдачи", () ->
                searchResultsPage.checkFirstResult(product1));
    }

    @Test
    @DisplayName("Очистка строки и новый поиск товара")
    void searchGoodsAfterClearingTest() {
        step("Открытие страницы search/", () ->
                search.openSearchPage());
        step("Ввод в строку поиска названия товара1", () ->
                search.enterValueInSearchInput(product1));
        step("Клик на иконку поиска", () ->
                search.clickSubmitIcon());
        step("Проверка заголовков страницы", () ->
                searchResultsPage.checkTitles(product1));
        step("Проверка отображения товара1 в первом результате выдачи", () ->
                searchResultsPage.checkFirstResult(product1));
        step("Клик на строку поиска", () ->
                search.clickInSearchInput());
        step("Очистка строки поиска", () ->
                search.clearSearchInput());
        step("Ввод в строку поиска названия товара2", () ->
                search.enterValueInSearchInput(product2));
        step("Проверка отображения товара2 в подсказках", () ->
                search.checkSuggest(product2));
        step("Клик на иконку поиска", () ->
                search.clickSubmitIcon());
        step("Проверка заголовков страницы", () ->
                searchResultsPage.checkTitles(product2));
        step("Проверка отображения товара2 в первом результате выдачи", () ->
                searchResultsPage.checkFirstResult(product2));
    }

    @Test
    @DisplayName("Поиск несуществующего товара")
    void searchInvalidProductTest() {
        step("Открытие страницы search/", () ->
                search.openSearchPage());
        step("Ввод неавлидного названия товара", () ->
                search.enterValueInSearchInput(invalidProduct));
        step("Проверка отображения информационного сообщения", () ->
                search.checkNoResultsMessage());
        step("Клик на иконку поиска", () ->
                search.clickSubmitIcon());
        step("Проверка отображения текста Нет товаров, соответствующих Вашему выбору. в заголовке", () ->
                searchResultsPage.checkNoResultsTitle());
    }
}
