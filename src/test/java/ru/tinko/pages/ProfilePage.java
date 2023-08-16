package ru.tinko.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
   private SelenideElement title = $("#breadcrumbs"),
    titleProfiles = $(".page-title"),
    createNewProfileButton = $(".btn-green"),
    profileName = $("#profile-name"),
    fio = $x("//input[@tabindex=13]"),
    phone = $x("//input[@tabindex=17]"),
    save = $("[name=save]"),
    newProfile = $(".profiles-list div"),
    deleteNewFile = $(".profiles-list div").$(".profiles-list__item-ui-delete"),
    profileDeletedMessage = $(".errortext");

    public ProfilePage checkTitle(){
       title.shouldHave(Condition.text("Личный кабинет"));
       return this;
    }
    public ProfilePage checkTitleProfiles(){
        titleProfiles.shouldHave(Condition.text("Профили"));
        return this;
    }
    public ProfilePage clickCreateNewProfileButton(){
        createNewProfileButton.click();
        return this;
    }
    public ProfilePage fillProfileName(String name){
        profileName.setValue(name);
        return this;
    }
    public ProfilePage fillProfileFio(String name){
        fio.setValue(name);
        return this;
    }
    public ProfilePage fillPhone(String phoneNumber){
        phone.setValue(phoneNumber);
        return this;
    }
    public ProfilePage clickSaveButton(){
        save.click();
        return this;
    }
    public ProfilePage checkNewProfile(String profileName, String firstName, String secondName){
        newProfile.shouldBe(visible);
        newProfile.shouldHave(text(profileName));
        newProfile.shouldHave(text(" " + secondName + " " + firstName));
        return this;
    }
    public ProfilePage deleteNewProfile(){
        deleteNewFile.click();
        return this;
    }
    public ProfilePage pressOkInAllertPopUp(){
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
        return this;
    }
    public ProfilePage checkMessageAfterDeleteProfile(){
        profileDeletedMessage.shouldHave(text("Профиль")).shouldHave(text("удален"));
        return this;
    }
}
