package lectures.lecture5.main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "src/lectures/lecture5/main/java/chromedriver.exe" );  // Подключение Chrome драйвера. Указываем системе, где будет находиться инструмент с помощью которого будем взаимодействовать с браузером
        WebDriver driver = new ChromeDriver();  // создаём экземпляр ChromeDriver
        driver.get( "https://www.google.com" ); // С помощью встроенных методов ChromeDriver, запрашиваем https://google.com
        WebElement searchBox = driver.findElement( By.name("q") );  // с помощью By.name() ищем поле для поискового запроса
        searchBox.sendKeys( "GeekBrains" );  // вводим в поисковое поле GeekBrains
        searchBox.submit();  // отправка формы
        Thread.sleep( 10000 ); // ожидание 10 сек
        driver.quit(); // закрытие окна браузера

    }
}
