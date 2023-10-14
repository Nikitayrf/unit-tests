import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import seminars.seminar2.simple_shopping_cart.Cart;
import seminars.seminar2.simple_shopping_cart.Main;
import seminars.seminar2.simple_shopping_cart.Shop;

import java.util.concurrent.TimeUnit;

public class ShopTest {

    /**
     * 2.1. Разработайте модульный тест для проверки, что общая стоимость
     * корзины с разными товарами корректно рассчитывается
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */

    @Test
    void priceCartIsCorrectCalculated() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 170 +
        cart.addProductToCartByID( 2 ); // 250 +
        cart.addProductToCartByID( 3 ); // 200 +
        // Assert (Проверка утверждение)
        assertThat( cart.getTotalPrice() ).isEqualTo( 620 );
    }

    /**
     * 2.2. Создайте модульный тест для проверки, что общая стоимость
     * корзины с множественными экземплярами одного и того же продукта корректно рассчитывается.
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */

    @Test
    void priceCartProductsSameTypeIsCorrectCalculated() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 170 +
        cart.addProductToCartByID( 1 ); // 170 +
        cart.addProductToCartByID( 2 ); // 250 +
        cart.addProductToCartByID( 3 ); // 200 +
        cart.addProductToCartByID( 3 ); // 200 +
        // Assert (Проверка утверждение)
        assertThat( cart.getTotalPrice() ).isEqualTo( 170 * 2 + 250 + 200 * 2 );
    }

    /**
     * 2.3. Напишите модульный тест для проверки, что при удалении
     * товара из корзины происходит перерасчет общей стоимости корзины.
     * <br><b>Ожидаемый результат:</b>
     * Вызывается метод пересчета стоимости корзины, стоимость корзины меняется
     */

    @Test
    void whenChangingCartCostRecalculationIsCalled() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 170 +
        cart.addProductToCartByID( 1 ); // 170 +
        cart.addProductToCartByID( 2 ); // 250 +
        cart.addProductToCartByID( 3 ); // 200 +
        cart.addProductToCartByID( 3 ); // 200 +
        cart.removeProductByID( 1 ); // 170 -
        cart.removeProductByID( 3 ); // 200 -
        // Assert (Проверка утверждение)
        assertThat( cart.getTotalPrice() ).isEqualTo( 170 + 250 + 200 );
    }

    /**
     * 2.4. Разработайте модульный тест для проверки, что при добавлении определенного количества товара в корзину,
     * общее количество этого товара в магазине соответствующим образом уменьшается.
     * <br><b>Ожидаемый результат:</b>
     * Количество товара в магазине уменьшается на число продуктов в корзине пользователя
     */

    @Test
    void quantityProductsStoreChanging() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        // Assert (Проверка утверждение)
        assertThat( shop.getProductsShop().get( 0 ).getQuantity() ).isEqualTo( 7 );
    }

    /**
     * 2.5. Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся продукты о
     * пределенного типа из магазина, эти продукты больше не доступны для заказа.
     * <br><b>Ожидаемый результат:</b>
     * Больше такой продукт заказать нельзя, он не появляется на полке
     */

    @Test
    void lastProductsDisappearFromStore() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        // Assert (Проверка утверждение)
        assertThat( cart.cartItems.get( 0 ).getQuantity() ).isEqualTo( 10 );
        assertThat( shop.getProductsShop().get( 0 ).getQuantity() ).isEqualTo( 0 );
    }

    /**
     * 2.6. Напишите модульный тест для проверки, что при удалении товара из корзины,
     * общее количество этого товара в магазине соответствующим образом увеличивается.
     * <br><b>Ожидаемый результат:</b>
     * Количество продуктов этого типа на складе увеличивается на число удаленных из корзины продуктов
     */

    @Test
    void deletedProductIsReturnedToShop() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.addProductToCartByID( 1 ); // 1 +
        cart.removeProductByID( 1 ); // 1 -
        cart.removeProductByID( 1 ); // 1 -
        // Assert (Проверка утверждение)
        assertThat( cart.cartItems.get( 0 ).getQuantity() ).isEqualTo( 1 );
        assertThat( shop.getProductsShop().get( 0 ).getQuantity() ).isEqualTo( 9 );
    }

    /**
     * 2.7. Разработайте параметризованный модульный тест для проверки,
     * что при вводе неверного идентификатора товара генерируется исключение RuntimeException.
     * <br><b>Ожидаемый результат:</b>
     * Исключение типа RuntimeException и сообщение Не найден продукт с id
     * *Сделать тест параметризованным
     */

    @ParameterizedTest
    @ValueSource(ints = {-100, 100, 20})
    void incorrectProductSelectionCausesException(int i) {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Assert (Проверка утверждение)
        // Попытка добавить товар с несуществующим id заданным в i. i берется из ints = {-100, 100, 20}
        // Через assertThatThrownBy перехватим факт, что исключение было вызвано
        assertThatThrownBy( () -> {
            cart.addProductToCartByID( i );
        } ).isInstanceOf( RuntimeException.class );
    }

    /**
     * 2.8.      * 2.8. Создайте модульный тест для проверки, что при попытке удалить из корзины больше товаров,
     * чем там есть, генерируется исключение RuntimeException.удаляет продукты до того, как их добавить)
     * <br><b>Ожидаемый результат:</b> Исключение типа NoSuchFieldError и сообщение "В корзине не найден продукт с id"
     */

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})
    void incorrectProductRemoveCausesException(int i) {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );

        // Assert (Проверка утверждение)
        assertThatThrownBy( () -> cart.removeProductByID( i ) ).isInstanceOf( RuntimeException.class );
    }

    /**
     * 2.9. Нужно восстановить тест
     */

    @Test
    void testSUM() {
        // Arrange (Подготовка)
        Shop shop = new Shop( Main.getStoreItems() );
        Cart cart = new Cart( shop );
        // Act (Выполнение)
        cart.addProductToCartByID( 2 ); // 250
        cart.addProductToCartByID( 2 ); // 250
        // Assert (Проверка утверждения)
        assertThat( cart.getTotalPrice() ).isEqualTo( 500 );

    }

    /**
     * 2.10. Нужно оптимизировать тестовый метод, согласно следующим условиям:
     * <br> 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
     * <br> 2. Тест повторяется 10 раз
     * <br> 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
     * <br> 4. После проверки работоспособности теста, его нужно выключить
     */

//    @Test
//    @DisplayName( "Advanced test for calculating TotalPrice" )
//    @RepeatedTest(10)
////    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
//    void testFinal() {
//        // Arrange (Подготовка)
//        Shop shop = new Shop( Main.getStoreItems() );
//        Cart cart = new Cart( shop );
//        // Act (Выполнение)
//        cart.addProductToCartByID( 2 ); // 250
//        cart.addProductToCartByID( 2 ); // 250
//        // Assert (Проверка утверждения)
//        assertThat( cart.getTotalPrice() ).isEqualTo( 500 );
//
//    }


}