package pages;

import test.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderPage extends TestBase {
    public void clickToCity() {

        open(baseUrl);
        $("[data-test-id=button__select-city]").click();
    }

    public void selectionCity() {

        $("[data-test-id=input__city-search]").setValue(city);
        $("[data-test-id=block__city]").click();
    }

    public void checkChangeCity() {

        $("#top-header").shouldHave(text(city));
    }
}
