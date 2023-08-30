package ru.tinko.pages;

import com.codeborne.selenide.SelenideElement;
import ru.tinko.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage extends TestBase {
    SelenideElement pageTitle = $(".col-content"),
            searchTitle = $(".search-subtitle"),
            catalogsProducts = $(".catalog-products__item-inner");

    public SearchResultsPage checkTitles(String value) {
        pageTitle.shouldHave(text("Поиск по каталогу"));
        searchTitle.shouldHave(text(value));
        return this;
    }

    public SearchResultsPage checkNoResultsTitle() {
        pageTitle.shouldHave(text("Нет товаров, соответствующих Вашему выбору."));
        return this;
    }

    public SearchResultsPage checkFirstResult(String value) {
        catalogsProducts.shouldHave(text(value));
        return this;
    }
}
