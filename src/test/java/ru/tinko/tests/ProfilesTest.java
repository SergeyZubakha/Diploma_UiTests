package ru.tinko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tinko.pages.ProfilePage;
import static io.qameta.allure.Allure.step;

@Epic("Tinko UiTests")
@Feature("Profiles")
public class ProfilesTest extends TestBase{
    LoginTest login = new LoginTest();
    ProfilePage profile = new ProfilePage();
    private String profileName = faker.pokemon().name(),
    firstName = faker.name().firstName(),
    secondName = faker.name().lastName(),
    name = firstName + " " + secondName,
    phone = faker.phoneNumber().phoneNumber();
    @Test
    @DisplayName("Создание нового профиля")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
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
        step("Проверка отображения нового профиля", () -> {
            profile.checkNewProfile(profileName, firstName, secondName);
        });
    }
    @Test
    @DisplayName("Удаление нового профиля")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
    void deleteNewProfile(){
        step("Логин юзером", () -> {
            login.successfulLoginTest();
        });
        step("Переход в Мои профили", () -> {
            mainPage.clickMyProfiles();
        });
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
