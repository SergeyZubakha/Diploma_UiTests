package ru.tinko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tinko.helpers.Attach;
import ru.tinko.config.WebConfiguration;
import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    //RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    static WebConfiguration config = ConfigFactory.create(WebConfiguration.class, System.getProperties());
    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //Configuration.screenshots = false;
        //Configuration.savePageSource = false;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //для запуска тестов удаленно
//        Configuration.pageLoadStrategy = "eager";
//
        Configuration.remote = System.getProperty("selenoidUrl"); //для запуска тестов удаленно
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.tinko.ru");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        baseUrl = config.baseUrl();
        browser = config.browser();
        browserVersion = config.browserVersion();
        pageLoadStrategy = "eager";
        browserSize = config.browserSize();
        if (config.isRemote()) {
            remote = config.remoteUrl();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

