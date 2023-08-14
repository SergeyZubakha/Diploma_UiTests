package ru.tinko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverConditions.*;

public class MainPage {
    private SelenideElement logoIcon = $(".header-above-logo__img"),
            howToBuy = $(".order-3"),
            hrefHowToBuy = $(".order-3 a[href*=howtobuy]"),
            delivery = $(".order-5"),
            hrefDelivery = $(".order-5 a[href*=delivery]"),
            contacts = $(".order-8"),
            hrefContacts = $(".order-8 a[href*=contacts]"),
            more = $(".order-12"),
            phones = $(".header-line-above__inner-right"),
            knowledgeUpdateCenter = $(".main-top__navigation-item-inner a[href*=knowledge]"),
            scheduleAndPrograms = $(".main-top__navigation-item-inner a[href*='http://community.tinko.ru/news/details/id/']"),
            salesRating = $(".main-top__navigation-item-inner a[href*=rating]"),
            journal = $(".main-top__navigation-item-inner a[href*=journal]");


    public MainPage openMainPage() {
        open("https://www.tinko.ru");
        return this;
    }
    public MainPage checkLogoImg() {
        logoIcon.should(be(visible));
        return this;
    }
    public MainPage checkHowToBuy() {
        howToBuy.shouldHave(text("Как купить?"));
        hrefHowToBuy.shouldBe(visible);
        return this;
    }
    public MainPage checkDelivery() {
        delivery.shouldHave(text("Доставка"));
        hrefDelivery.shouldBe(visible);
        return this;
    }
    public MainPage checkContacts() {
        contacts.shouldHave(text("Контакты"));
        hrefContacts.shouldBe(visible);
        return this;
    }
    public MainPage checkMore() {
        more.shouldHave(text("Ещё"));
        return this;
    }
    public MainPage checkPhonesNumbers() {
        phones.shouldHave(text("8 (495) 708-42-13"));
        phones.shouldHave(text("Звонок бесплатный"));
        phones.shouldHave(text("8 (800) 200-84-65"));
        return this;
    }
    public MainPage checkNavigationList() {
        knowledgeUpdateCenter.shouldHave(text("Центр актуализации знаний"));
        scheduleAndPrograms.shouldHave(text("Расписание и программы вебинаров"));
        salesRating.shouldHave(text("Рейтинг продаж «ТД ТИНКО»"));
        journal.shouldHave(text("Журнал «Грани безопасности»"));


        return this;
    }
    public MainPage clickHowToBuy(){
        howToBuy.click();
        return this;
    }
    public MainPage clickLogoIcon(){
        logoIcon.click();
        return this;
    }
}
