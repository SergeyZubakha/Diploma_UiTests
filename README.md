# Дипломный проект по автоматизации тестирования сайта <a href="https://https://www.tinko.ru// ">ТинкоТД</a></h1>
![logo-dark.svg](images/logo/logo-dark.svg width=200 height=100)
### Технологии и инструменты:
<p align="center">
<img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/>
<img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/>
<img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure_TO"/>
<img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/>
</p>

### Реализованные проверки:
* Проверка отображения элементов хедера страницы
* Проверка возврата на главную при клике на лого
* Проверка отображения элементов футера страницы
* Успешная авторизация
* Ввод невалидного пароля
* Попытка авторизации без заполнения обязательных полей
* Создание нового профиля
* Удаление созданного профиля
* Проверка сторки поиска товаров

### Запуск тестов из терминала
#### Локальный запуск тестов:
```bash
gradle clean test
```

#### Удаленный запуск тестов с параметрами:

```bash
gradle clean test
-DbaseUrl=${BASE_URL}
-DselenoidUrl=${SELENOID_URL}
-DbrowserSize=${BROWSER_SIZE}

```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
> `${BROWSER_VERSION}` - версия браузера (_по умолчанию - <code>100.0</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${REMOTE_URL}` - адрес удаленного сервера, на котором будут запускаться тесты.

### Запуск тестов в Jenkins
<a target="_blank" href="https://jenkins.autotests.cloud/job/AD_demo_ui_steam/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>

### Отчет в Allure report
#### Основная страница отчета
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureReport.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/TK.png">
</p>

### Интеграция с Allure TestOps
#### Dashboard
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureTestOps.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/AllureTestopsTK.png">
</p>

### Интеграция с Jira
<p align="center">
<img title="Jenkins Build" src="images/screens/Jira.png">
</p>

### Уведомления в Telegram с использованием бота
<p align="center">
<img title="Jenkins Build" src="images/screens/Telegram.png">
</p>

### Пример видео выполнения теста на Selenoid
<p align="center">
  <img title="Selenoid Video" src="images/screens/video-3.gif">
</p>
