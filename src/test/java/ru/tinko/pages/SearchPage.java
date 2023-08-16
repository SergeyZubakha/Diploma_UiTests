package ru.tinko.pages;

import com.codeborne.selenide.SelenideElement;
import ru.tinko.tests.TestBase;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage extends TestBase {
    SelenideElement searchInput = $("[name=q]"),
    searchResults = $(".header-search-result"),
    allResultButton = $(".header-search-result__all"),
    submitIcon = $("[type=submit]"),
    pageTitle = $(".col-content"),
    searchTitle = $(".search-subtitle"),
    catalogsProducts = $(".catalog-products__item-inner"),
    emptyResults = $(".header-search-result__empty");

    public SearchPage openSearchPage(){
        open("/search");
        return this;
    }
    public SearchPage enterValueInSearchInput(String value){
        searchInput.setValue(value);
        return this;
    }
    public SearchPage checkSuggest(String value){
        searchResults.shouldHave(text(value));
        allResultButton.shouldBe(visible);
        return this;
    }
    public SearchPage clickSubmitIcon(){
        submitIcon.click();
        return this;
    }
    public SearchPage checkTitles(String value){
        pageTitle.shouldHave(text("Поиск по каталогу"));
        searchTitle.shouldHave(text(value));
        return this;
    }
    public SearchPage checkFirstResult(String value){
        catalogsProducts.shouldHave(text(value));
        return this;
    }
    public SearchPage clickInSearchInput(){
        searchInput.click();
        return this;
    }
    public SearchPage clearSearchInput(){
        searchInput.clear();
        return this;
    }
    public SearchPage checkSuggestNotVisible() {
        searchResults.shouldNotBe(visible);
        return this;
    }
    public SearchPage clickShowAllResults() {
        allResultButton.click();
        return this;
    }
    public SearchPage checkNoResultsMessage(){
        emptyResults.shouldHave(text("Нет товаров, соответствующих Вашему выбору."));
        return this;
    }
    public SearchPage checkNoResultsTitle(){
        pageTitle.shouldHave(text("Нет товаров, соответствующих Вашему выбору."));
        return this;
    }
}
