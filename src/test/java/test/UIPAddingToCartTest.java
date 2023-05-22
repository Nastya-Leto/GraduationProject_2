package test;

import data.annotation.Blocker;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.WorkWithProductPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Добавление товара в корзину")
public class UIPAddingToCartTest extends TestBase {

    WorkWithProductPage workWithProductPage = new WorkWithProductPage();


    @Test
    @DisplayName("Проверка добавления товара в корзину")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Blocker()
    @Owner("ZakharovaAA")
    void addingProductToTheCart() {


        step("Поиск товара", () -> {

            workWithProductPage.productSearch();
        });
        step("Открытие карточки первого товара из списка", () -> {

            workWithProductPage.openCard();
        });

        step("Добавление товара в корзину", () -> {

            workWithProductPage.addingToCart();

        });

        step("Проверка наличия товара в корзине", () -> {

            workWithProductPage.checkItemInCart();

        });
    }
}
