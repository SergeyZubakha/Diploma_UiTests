package ru.tinko.tests;

import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase{
    @Test
    void successfulLoginTest(){
        mainPage.openMainPage()
                .loginUser(userName,password)
                .clickLogin()
                .checkTitleAfterSuccessfulLogin();
    }
}
