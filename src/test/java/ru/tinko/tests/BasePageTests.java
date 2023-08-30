package ru.tinko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Tinko UiTests")
@Feature("New_Design_BasePage")
@Owner("s.zubakha")
@Severity(SeverityLevel.NORMAL)
public class BasePageTests extends TestBase {
    @Test
    @DisplayName("Проверка отображения элементов хедера страницы")

    void headerTest() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Проверка наполнения шапки сайта", () -> {
            mainPage.checkLogoImg()
                    .checkCompany()
                    .checkNews()
                    .checkHowToBuy()
                    .checkPriceList()
                    .checkDelivery()
                    .checkSupport()
                    .checkForum()
                    .checkContacts()
                    .checkPhonesNumbers();
        });
    }

    @Test
    @DisplayName("Проверка возврата на главную при клике на лого")
    void returnToBasicPageTest() {
        step("Открытие главной страницы", () ->
                mainPage.openMainPage());
        step("Переход на страницу /howtobuy", () ->
                mainPage.clickHowToBuy());
        step("Клик на иконку логотипа", () ->
                mainPage.clickLogoIcon());
        step("Проверка перехода на главную, с помощью проверки основных элементов главной", () ->
                mainPage.checkNavigationList());
    }

    @Test
    @DisplayName("Проверка отображения элементов футера страницы")
    void footerTest() {
        step("Проверка отображения блоков Компания, Наши предложения, Сервис", () -> {
            mainPage.openMainPage()
                    .checkCompanyBloc()
                    .checkOurOffersBloc()
                    .checkServiceBloc();
        });
        step("Проверка наличия ссылок в блоках Компания, Наши предложения, Сервис", () -> {
            mainPage.checkHrefInCompanyBloc()
                    .checkHrefInOurOffersBloc()
                    .checkHrefInServiceBloc();
        });
    }
}


