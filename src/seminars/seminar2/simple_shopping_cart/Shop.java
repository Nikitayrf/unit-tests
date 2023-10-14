package seminars.seminar2.simple_shopping_cart;

import java.util.List;

public class Shop {
    // Список продуктов в магазине
    private final List<Product> productsShop;

    // При создании магазина нужно передать ему список продуктов
    public Shop(List<Product> productShop) {
        this.productsShop = productShop;
    }

    // Метод получения текущего списка продуктов
    public List<Product> getProductsShop() {
        return productsShop;
    }

}
