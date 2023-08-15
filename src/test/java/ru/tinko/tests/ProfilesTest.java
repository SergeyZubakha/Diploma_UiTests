package ru.tinko.tests;

import org.junit.jupiter.api.Test;
import ru.tinko.pages.ProfilePage;

import static io.qameta.allure.Allure.step;

public class ProfilesTest extends TestBase{
    LoginTest login = new LoginTest();
    ProfilePage profile = new ProfilePage();
    private String profileName = faker.pokemon().name(),
    firstName = faker.name().firstName(),
    secondName = faker.name().lastName(),
    name = firstName + " " + secondName,
    phone = faker.phoneNumber().phoneNumber();
    @Test
    void createNewProfile(){
        step("Логин юзером", () -> {
                    login.successfulLoginTest();
                });
        step("Переход в Мои профили", () -> {
                    mainPage.clickMyProfiles();
                });
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
        step("Проверка отобрадения нового профиля", () -> {
            profile.checkNewProfile(profileName, firstName, secondName);
        });
    }
    @Test
    void deleteNewProfile(){
        step("Создание нового профиля", () -> {
                    createNewProfile();
        });
        step("Удаление нового профиля", () -> {
            profile.deleteNewProfile()
                    .pressOkInAllertPopUp()
                    .checkMessageAfterDeleteProfile();
        });
    }
}
