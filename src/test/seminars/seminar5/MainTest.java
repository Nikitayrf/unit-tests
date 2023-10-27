package seminars.seminar5;

import org.junit.jupiter.api.Test;
import seminars.seminar5.number.MaxNumberModule;
import seminars.seminar5.number.RandomNumberModule;
import seminars.seminar5.user.UserRepository;
import seminars.seminar5.user.UserService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    //5.1.

    /**
     * Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
     * максимальное число в этом списке.
     * Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
     * тест, который проверяет, что оба модуля работают вместе правильно
     */
    // Тест проверяет, что generateRandomNumbers() генерирует столько значений, сколько задали
    @Test
    public void TestRandomModule() {
        RandomNumberModule generator = new RandomNumberModule();
        int[] numbers = generator.generateRandomNumbers( 10 );

        assertEquals( 10, numbers.length );
    }

    // Тест проверяет, что findMaxNumber() находим максимальное число в массиве.
    @Test
    public void TestMaxNumberModule() {
        MaxNumberModule finder = new MaxNumberModule();
        int[] numbers = {3, 4, 6, 9, 1};
        int max = finder.findMaxNumber( numbers );

        assertEquals( 9, max );
    }

    // Интеграционный тест связывающий MaxNumberModule и RandomNumberModule
    @Test
    public void IntegrationTestMaxAndRandom() {
        RandomNumberModule generator = new RandomNumberModule();
        MaxNumberModule finder = new MaxNumberModule();

        int[] numbers = generator.generateRandomNumbers( 10 );
        int max = finder.findMaxNumber( numbers );
        Arrays.sort( numbers );
        int referenceMax = numbers[numbers.length - 1];

        assertEquals( referenceMax, max );
    }

    //5.2.
    /**
     * У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
     * получения информации о пользователе. Ваша задача - написать интеграционный тест, который
     * проверяет, что UserService и UserRepository работают вместе должным образом.
     */
    @Test
    public void IntegrationTestUserServiceAndUserRepository() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService( userRepository );

        assertEquals( "User 1", userService.getUserName( 1 ) );
    }

    //5.3.
    /**
     * У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
     * PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
     * PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
     * который проверяет, что OrderService и PaymentService взаимодействуют корректно
     */
}