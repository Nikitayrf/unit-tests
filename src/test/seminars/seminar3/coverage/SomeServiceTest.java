package seminars.seminar3.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class SomeServiceTest {
    private SomeService someService;


    @BeforeEach
    void setUP() {
        someService = new SomeService();
    }

    // 3.1.

    /**
     * Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz. Эта
     * функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
     * если число делится на 5, и "FizzBuzz", если число делится на 15. Если число не делится ни
     * на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.
     *
     * @param n входные данные
     */

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 12})
    void multipleThreeNotFiveReturnsFizz(int n) {
        assertEquals( "Fizz", someService.fizzBuzz( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 5, 25})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        assertEquals( "Buzz", someService.fizzBuzz( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45})
    void multipleFifteenNotThreeNotFiveReturnsFizzBuzz(int n) {
        assertEquals( "FizzBuzz", someService.fizzBuzz( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, 8})
    void multipleNotFifteenNotThreeNotFiveReturnsString(int n) {
        assertEquals( Integer.toString( n ), someService.fizzBuzz( n ) );
    }

    // 3.2.

    /**
     * Разработайте тесты для метода firstLast6, где на вход подается массив чисел, а метод
     * возвращает true, если первое или последнее число в массиве равно 6, иначе false.
     */

    @Test
    void firstLast6Where6FirstReturnsTrue() {
        assertTrue( someService.firstLast6( new int[]{6, 0, 0, 1, 5} ) );
    }

    @Test
    void firstLast6Where6LastReturnsTrue() {
        assertTrue( someService.firstLast6( new int[]{0, 5, 3, 6} ) );
    }

    @Test
    void firstLast6ReturnsFalse() {
        assertFalse( someService.firstLast6( new int[]{1, 2, 3, 4, 5} ) );
    }

    // 3.3.

    /**
     * Создайте тесты, обеспечивающие полное покрытие кода метода calculatingDiscount, который принимает сумму
     * покупки и размер скидки, затем вычисляет и возвращает сумму с учетом скидки. Метод должен обрабатывать
     * исключения, связанные с некорректным размером скидки или отрицательной суммой покупки.
     */

    @Test
    void calculatingDiscountReturnsCorrectPurchaseAmount() {
        assertEquals( 90, someService.calculatingDiscount( 100, 10 ) );
    }

    @Test
    void calculatingDiscountFalseDiscountLessThan0() {
        assertThatThrownBy( () -> someService.calculatingDiscount( 100, -10 ) ).isInstanceOf( ArithmeticException.class );
    }

    @Test
    void calculatingDiscountFalseDiscountMoreThan100() {
        assertThatThrownBy( () -> someService.calculatingDiscount( 100, 222 ) ).isInstanceOf( ArithmeticException.class );
    }

    // 3.4.

    /**
     * Разработайте метод luckySum и напишите для него тесты. Этот метод принимает на вход три числа и возвращает
     * их сумму. Однако, если одно из чисел равно 13, то оно не учитывается при подсчете суммы.
     */

    @Test
    void luckySumReturnsABC() {
        assertEquals( 6, someService.luckySum( 1, 2, 3 ) );
    }

    @Test
    void luckySumReturnsBC() {
        assertEquals( 5, someService.luckySum( 13, 2, 3 ) );
    }

    @Test
    void luckySumReturnsAC() {
        assertEquals( 4, someService.luckySum( 1, 13, 3 ) );
    }

    @Test
    void luckySumReturnsAB() {
        assertEquals( 3, someService.luckySum( 1, 2, 13 ) );
    }


}
