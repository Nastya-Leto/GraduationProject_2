package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.Section;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.remote.DesiredCapabilities;
import testrail.APIClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestBase {

    public String product = "Вафельница";
    public String city = "Самара";
    public String message = "В корзине пока нет товаров";

    /*public static final APIClient client = new APIClient("http:///testrail/");

    public TestBase() {
        client.setUser("stasia-oops@yandex.ru");
        client.setPassword("Zai6598084*");
    }*/

    public static Stream<Arguments> sectionContentTest() {
        return Stream.of(
                Arguments.of(Section.Одежда, List.of("Все категории", "Одежда",
                        "Детская одежда", "Женская одежда", "Мужская одежда", "Спецодежда")),
                Arguments.of(Section.Обувь, List.of("Все категории", "Обувь", "Аксессуары для обуви",
                        "Специализированная обувь", "Женская обувь", "Мужская обувь",
                        "Обувь для девочек", "Обувь для мальчиков"))
        );
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
    }

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://kazanexpress.ru/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        RestAssured.baseURI = "https://qanastya.testrail.io/index.php";




       /* DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true

        ));
        Configuration.browserCapabilities = capabilities;
*/


    }
}

