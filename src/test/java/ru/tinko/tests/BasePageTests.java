package ru.tinko.tests;

import org.junit.jupiter.api.Test;
import ru.tinko.pages.MainPage;

import static io.qameta.allure.Allure.addStreamAttachmentAsync;
import static io.qameta.allure.Allure.step;

public class BasePageTests extends TestBase {
    @Test
    void headerTest(){

        step("Открытие главной страницы", () -> {
            mainPage.openMainPage();
        });
        step("Проверка наполнения шапки сайта", () -> {
            mainPage.checkLogoImg()
                    .checkHowToBuy()
                    .checkDelivery()
                    .checkContacts()
                    .checkMore()
                    .checkPhonesNumbers();
        });
    }
    @Test
    void iconTest() {
        step("Открытие главной страницы", () -> {
            mainPage.openMainPage();
        });
        step("Переход на страницу /howtobuy", () -> {
            mainPage.clickHowToBuy();
        });
        step("Клик на иконку логотипа", () -> {
            mainPage.clickLogoIcon();
        });
        step("Проверка перехода на главную, с помощью провеки основных элементов главной", () -> {
            mainPage.checkNavigationList();
        });
    }
        @Test
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


