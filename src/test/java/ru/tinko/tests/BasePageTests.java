package ru.tinko.tests;

import org.junit.jupiter.api.Test;
import ru.tinko.pages.MainPage;

import static io.qameta.allure.Allure.addStreamAttachmentAsync;
import static io.qameta.allure.Allure.step;

public class BasePageTests {
    MainPage  mainPage = new MainPage();
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
    void iconTest(){
        mainPage.openMainPage()
                .clickHowToBuy()
                .clickLogoIcon()
                .checkNavigationList();
    }
}
