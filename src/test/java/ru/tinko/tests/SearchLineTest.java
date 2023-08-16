package ru.tinko.tests;

import org.junit.jupiter.api.Test;
import ru.tinko.pages.SearchPage;
import static io.qameta.allure.Allure.step;

public class SearchLineTest extends TestBase {
    private String product1 = "Молния-12";
    private String product2 = "Маяк-220-С";
    private String invalidProduct = "whereIsMyGoods";
    SearchPage search = new SearchPage();
    @Test
    void searchLineInMainPageTest(){
        step("Открытие главной страницы", () -> {
            mainPage.openMainPage();
                });
        step("Ввод в строку поиска названия товара1", () -> {
            search.enterValueInSearchInput(product1);
        });
        step("Проверка отображения товара1 в подсказках", () -> {
            search.checkSuggest(product1);
        });
    }
    @Test
    void searchLineInSearchPageTest(){
        step("Открытие страницы search/", () -> {
            search.openSearchPage();
        });
        step("Ввод в строку поиска названия товара1", () -> {
            search.enterValueInSearchInput(product1);
        });
        step("Проверка отображения товара1 в подсказках", () -> {
            search.checkSuggest(product1);
        });
        step("Клик на иконку поиска", () -> {
            search.clickSubmitIcon();
        });
        step("Проверка заголовков страницы", () -> {
            search.checkTitles(product1);
        });
        step("Проверка отображения товара1 в первом результате выдачи", () -> {
            search.checkFirstResult(product1);
        });
    }

    @Test
    void showAllResultsInSuggestTest(){
        step("Открытие страницы search/", () -> {
            search.openSearchPage();
        });
        step("Ввод в строку поиска названия товара1", () -> {
            search.enterValueInSearchInput(product1);
        });
        step("Проверка отображения товара1 в подсказках", () -> {
            search.checkSuggest(product1);
        });
        step("Клик на кнопку показать все результаты", () -> {
            search.clickShowAllResults();
        });
        step("Проверка заголовков страницы", () -> {
            search.checkTitles(product1);
        });
        step("Проверка отображения товара1 в первом результате выдачи", () -> {
            search.checkFirstResult(product1);
        });
    }
    @Test
    void searchGoodsAfterClearingTest(){
        step("Открытие страницы search/", () -> {
            search.openSearchPage();
        });
        step("Ввод в строку поиска названия товара1", () -> {
            search.enterValueInSearchInput(product1);
        });
        step("Клик на иконку поиска", () -> {
            search.clickSubmitIcon();
        });
        step("Проверка заголовков страницы", () -> {
            search.checkTitles(product1);
        });
        step("Проверка отображения товара1 в первом результате выдачи", () -> {
            search.checkFirstResult(product1);
        });
        step("Клик на строку поиска", () -> {
            search.clickInSearchInput();
        });
        step("Очистка строки поиска", () -> {
            search.clearSearchInput();
        });
        step("Ввод в строку поиска названия товара2", () -> {
            search.enterValueInSearchInput(product2);
        });
        step("Проверка отображения товара2 в подсказках", () -> {
            search.checkSuggest(product2);
        });
        step("Клик на иконку поиска", () -> {
            search.clickSubmitIcon();
        });
        step("Проверка заголовков страницы", () -> {
            search.checkTitles(product2);
        });
        step("Проверка отображения товара2 в первом результате выдачи", () -> {
            search.checkFirstResult(product2);
        });
    }
    @Test
    void searchInvalidProductTest(){
        step("Открытие страницы search/", () -> {
            search.openSearchPage();
        });
        step("Ввод неавлидного названия товара", () -> {
            search.enterValueInSearchInput(invalidProduct);
        });
        step("Проверка отображения информационного сообщения", () -> {
            search.checkNoResultsMessage();
        });
        step("Клик на иконку поиска", () -> {
            search.clickSubmitIcon();
        });
        step("Проверка отображения текста Нет товаров, соответствующих Вашему выбору. в заголовке", () -> {
            search.checkNoResultsTitle();
        });
    }
}
