package ru.tinko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Epic("Tinko UiTests")
@Feature("Login")
public class LoginTest extends TestBase {
    @Test
    @DisplayName("Успешная авторизация")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void successfulLoginTest() {
        step("Ввод валидного логина и пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, password)
                    .clickLogin();
        });
        step("Проверка отображение имени и фамилии в заголовке", () -> {
            mainPage.checkTitleAfterSuccessfulLogin();
        });
    }
    @Test
    @DisplayName("Ввод невалидного пароля")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void unsuccessfulLoginTest(){
        step("Ввод валидного логина и невалидного пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, String.valueOf(faker.rickAndMorty()))
                    .clickLogin();
        });
        step("Проверка отображения сообщения об ошибке", () -> {
            mainPage.checkErrorMessage();
        });
        }
    @Test
    @DisplayName("Попытка авторизации без пароля")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
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
    @DisplayName("Попытка авторизации без заполнения полей")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
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

