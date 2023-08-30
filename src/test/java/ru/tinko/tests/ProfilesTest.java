package ru.tinko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tinko.pages.ProfilePage;

import static io.qameta.allure.Allure.step;

@Epic("Tinko UiTests")
@Feature("Profiles")
@Owner("s.zubakha")
@Severity(SeverityLevel.NORMAL)
public class ProfilesTest extends TestBase {
    ProfilePage profile = new ProfilePage();
    private String profileName = faker.pokemon().name(),
            firstName = faker.name().firstName(),
            secondName = faker.name().lastName(),
            name = firstName + " " + secondName,
            phone = faker.phoneNumber().phoneNumber();

    @Test
    @DisplayName("Создание нового профиля")
    void createNewProfile() {
        step("Ввод валидного логина и пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, password)
                    .clickLogin()
                    .clickLoginIcon();
        });
        step("Переход в Мои профили", () ->
                mainPage.clickMyProfiles());
        step("Проверка отображения заголовков страницы /personal/profiles", () -> {
            profile.checkTitle()
                    .checkTitleProfiles();
        });
        step("Создание нового профиля", () -> {
            profile.clickCreateNewProfileButton()
                    .fillProfileName(profileName)
                    .fillProfileFio(name)
                    .fillPhone(phone)
                    .clickSaveButton();
        });
        step("Проверка отображения нового профиля", () ->
                profile.checkNewProfile(profileName, firstName, secondName));
    }

    @Test
    @DisplayName("Удаление нового профиля")
    void deleteNewProfile() {
        step("Ввод валидного логина и пароля", () -> {
            mainPage.openMainPage()
                    .loginUser(userName, password)
                    .clickLogin()
                    .clickLoginIcon();
        });
        step("Переход в Мои профили", () ->
                mainPage.clickMyProfiles());
        step("Создание нового профиля", () -> {
            profile.clickCreateNewProfileButton()
                    .fillProfileName(profileName)
                    .fillProfileFio(name)
                    .fillPhone(phone)
                    .clickSaveButton();
        });
        step("Удаление нового профиля", () -> {
            profile.deleteNewProfile()
                    .pressOkInAllertPopUp()
                    .checkMessageAfterDeleteProfile();
        });
    }
}
