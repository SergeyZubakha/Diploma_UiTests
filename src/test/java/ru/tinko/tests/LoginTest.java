package ru.tinko.tests;

import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase {
    @Test
    void successfulLoginTest() {
        step("Ввод валдного логина и пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, password)
                    .clickLogin();
        });
        step("Проверка авторизации, проверка отображение имени и фамилии в заголовке", () -> {
            mainPage.checkTitleAfterSuccessfulLogin();
        });
    }
    @Test
    void unsuccessfulLoginTest(){
        step("Ввод валдного логина и пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, String.valueOf(faker.rickAndMorty()))
                    .clickLogin();
        });
        step("Проверка отображения сообщения об ошибке", () -> {
            mainPage.checkErrorMessage();
        });
        }
    @Test
    void loginWithoutPassTest(){
        step("Ввод валидного логина без пароля", () -> {
            mainPage.openMainPage()
                    .loginUserWithoutPass(userName)
                    .clickLogin();
        });
        step("Проверка отображения сообщения об ошибке", () -> {
            mainPage.checkPasswordIsEmptyMessage();
        });
    }
    @Test
    void loginWithoutLoginAndPassTest(){
        step("Поля ввода остаются пустыми, клик по кноке войти", () -> {
            mainPage.openMainPage()
                    .loginUserWithoutLoginAndPass()
                    .clickLogin();
        });
        step("Проверка отображения сообщений об ошибках", () -> {
            mainPage.checkErrorMessages();
        });
    }
}

