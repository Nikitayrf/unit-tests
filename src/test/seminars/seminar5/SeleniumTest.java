package seminars.seminar5;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.C;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    //5.4.

    /**
     * Напишите автоматизированный тест, который выполнит следующие шаги:
     * 1. Открывает главную страницу Google.
     * 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
     * 3. В результатах поиска ищет ссылку на официальный сайт Selenium (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди результатов поиск
     */
    @Test
    public void seleniumTest() {
        System.setProperty( "webdriver.chrome.driver", "src/lectures/lecture5/main/java/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.google.com" );
        WebElement searchBox = driver.findElement( By.name( "q" ) );
        searchBox.sendKeys( "Selenium" );
        searchBox.submit();
        List<WebElement> searchresult = driver.findElements( By.cssSelector( "div" ) );
        boolean isFind = false;
        for (WebElement ls : searchresult) {
            if (ls.getText().contains( "https://www.selenium.dev" )) {
                isFind = true;
                break;
            }
        }
        assertTrue( isFind );
        driver.quit();
    }

    //5.5.

    /**
     * Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
     * сайте https://www.saucedemo.com/.
     * Данные для входа - логин: "standard_user", пароль: "secret_sauce".
     * Проверить, что авторизация прошла успешно и отображаются товары.
     * Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
     * данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
     * отображаются продукты (productsLabel.getText() = "Products").
     */

    @Test
    public void seleniumSaucedemoTest() {
        System.setProperty( "webdriver.chrome.driver", "src/lectures/lecture5/main/java/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.saucedemo.com" );
        WebElement usernameField = driver.findElement( By.id("user-name") );
        WebElement passwordField = driver.findElement( By.id("password") );
        WebElement loginButton = driver.findElement( By.id(  "login-button") );
        usernameField.sendKeys( "standard_user" );
        passwordField.sendKeys( "secret_sauce" );
        loginButton.click();
        WebElement productLable = driver.findElement( By.className( "title" ) );
        assertEquals("Products", productLable.getText());
        driver.quit();

    }

}
