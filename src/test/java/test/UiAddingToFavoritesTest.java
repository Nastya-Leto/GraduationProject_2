package test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.WorkWithProductPage;

import static io.qameta.allure.Allure.step;

@Disabled
public class UiAddingToFavoritesTest extends TestBase {
    WorkWithProductPage workWithProductPage = new WorkWithProductPage();

    @Test
    @DisplayName("Проверка добавления товара в избранное")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")

    void addingProductToTheCart() {


        step("Поиск товара", () -> {

            workWithProductPage.productSearch();

        });
        step("Открытие карточки первого товара из списка", () -> {

            workWithProductPage.openCard();
        });

        step("Добавление товара в избранное", () -> {

            workWithProductPage.addingToFavorites();

        });

        step("Проверка наличия товара в избранном", () -> {

            workWithProductPage.checkItemInFavorites();

        });
    }
}
