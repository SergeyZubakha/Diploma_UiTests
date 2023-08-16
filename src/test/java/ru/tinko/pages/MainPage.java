package ru.tinko.pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
            journal = $(".main-top__navigation-item-inner a[href*=journal]"),
            company = $x("//p[contains(@class, 'footer-menu__title') and text() = 'Компания']"),
            partnerCertificates = $(".footer-menu__list a[href*=partners]"),
            vacancies = $(".footer-menu__list a[href*=vacancies]"),
            companyAddress = $(".footer-menu__list a[href*=contacts]"),
            ourOffers = $x("//p[contains(@class, 'footer-menu__title') and text() = 'Наши предложения']"),
            brands = $(".footer-menu__list a[href*=brands]"),
            functional = $(".footer-menu__list a[href*=functional]"),
            service = $x("//p[contains(@class, 'footer-menu__title') and text() = 'Сервис']"),
            repair = $(".footer-menu__list a[href*=repair]"),
            support = $(".footer-menu__list a[href*=support]"),
            help = $(".footer-menu__list a[href*=help]"),
            loginIcon = $("#personal-menu"),
            userLoginInput = $("[name=USER_LOGIN]"),
            userPasswordInput = $("[name=USER_PASSWORD]"),
            loginButton = $("#login_auth_submit"),
            personalTitle = $(".personal-title"),
            companyInHeader = $(".order-1"),
            hrefCompanyInHeader = $(".order-1 a[href*=company]"),
            news = $(".order-2"),
            hrefNews = $(".order-2 a[href*=news]"),
            price = $(".menu-dropdown-item a[href*=pricelist]"),
            supportInHeader = $(".order-6"),
            hrefSupportInHeader = $(".order-6 a[href*=support]"),
            forum = $(".order-7"),
            hrefForum = $(".order-7 a[href*='https://community.tinko.ru/']"),
            authorizedUserIcon = $(".authorized"),
            errorMessage = $("#auth-error"),
            passwordIsEmptyMessage = $("#USER_PASSWORD-error"),
            userLoginError = $("#USER_LOGIN-error"),
            myProfiles =  $("#headerPersonalAuth").find(byText("Мои профили"));

    public MainPage openMainPage() {
        open("https://www.tinko.ru");
        return this;
    }
    public MainPage checkLogoImg() {
        logoIcon.should(be(visible));
        return this;
    }
    public MainPage checkCompany() {
        companyInHeader.shouldHave(text("Компания"));
        hrefCompanyInHeader.shouldBe(visible);
        return this;
    }
    public MainPage checkNews() {
        news.shouldHave(text("Новости"));
        hrefNews.shouldBe(visible);
        return this;
    }
    public MainPage checkPriceList() {
        price.shouldBe(visible);
        price.shouldHave(text("Прайс-лист"));
        return this;
    }
    public MainPage checkSupport() {
        supportInHeader.shouldHave(text("Техническая поддержка"));
        hrefSupportInHeader.shouldBe(visible);
        return this;
    }
    public MainPage checkForum() {
        forum.shouldHave(text("Форум"));
        hrefForum.shouldBe(visible);
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
    public MainPage checkCompanyBloc(){
        company.shouldBe(visible);
        return this;
    }
    public MainPage checkHrefInCompanyBloc(){
        partnerCertificates.shouldHave(text("Партнерские сертификаты"));
        vacancies.shouldHave(text("Вакансии"));
        companyAddress.shouldHave(text("Адрес офиса"));
        return this;
    }
    public MainPage checkOurOffersBloc(){
        ourOffers.shouldBe(visible);
        return this;
    }
    public MainPage checkHrefInOurOffersBloc(){
        brands.shouldHave(text("Бренды"));
        functional.shouldHave(text("Функциональные группы"));
        return this;
    }
    public MainPage checkServiceBloc(){
        service.shouldBe(visible);
        return this;
    }
    public MainPage checkHrefInServiceBloc(){
        repair.shouldHave(text("Гарантийный ремонт"));
        support.shouldHave(text("Техническая поддержка"));
        help.shouldHave(text("Помощь по сайту"));
        return this;
    }
    public MainPage loginUser(String login, String password){
        loginIcon.shouldBe(visible);
        loginIcon.click();
        userLoginInput.shouldBe(visible);
        userLoginInput.setValue(login);
        userPasswordInput.setValue(password);
        return this;
    }
    public MainPage clickLogin(){
        loginButton.click();
        return this;
    }
    public MainPage checkTitleAfterSuccessfulLogin(){
        authorizedUserIcon.shouldBe(visible);
        loginIcon.click();
        personalTitle.shouldHave(text("Тест Тестович"));
        return this;
    }
    public MainPage checkErrorMessage(){
        errorMessage.shouldHave(text("Указан неверный e-mail или пароль."));
        return this;
    }
    public MainPage loginUserWithoutPass(String login) {
        loginIcon.click();
        userLoginInput.setValue(login);
        return this;
    }
    public MainPage checkPasswordIsEmptyMessage(){
        passwordIsEmptyMessage.shouldHave(text("Пароль пуст"));
        return this;
    }
    public MainPage loginUserWithoutLoginAndPass() {
        loginIcon.click();
        return this;
    }
    public MainPage checkErrorMessages(){
        userLoginError.shouldHave(text("Это поле обязательно для заполнения"));
        passwordIsEmptyMessage.shouldHave(text("Пароль пуст"));
        return this;
    }
    public MainPage clickMyProfiles(){
        myProfiles.shouldBe(visible);
        myProfiles.click();
        return this;
    }
}
