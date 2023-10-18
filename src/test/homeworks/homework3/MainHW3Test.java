package homeworks.homework3;

import homeworks.homework3.hw.MainHW3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHW3Test {

    private MainHW3 mainHW3;

    @BeforeEach
    void setUP() {
        mainHW3 = new MainHW3();
    }

    // 3.1. Homework3

    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * переданное число четным или нечетным
     */

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void evenOddNumberTrue(int n) {
        assertTrue( mainHW3.evenOddNumber( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void evenOddNumberFalse(int n) {
        assertFalse( mainHW3.evenOddNumber( n ) );
    }

    // 3.2. homework3

    /**
     * Разработайте и протестируйте метод numberInInterval, который проверяет,
     * попадает ли переданное число в интервал (25;100)
     */

    @ParameterizedTest
    @ValueSource(ints = {26, 30, 99})
    void numberInIntervalTrue(int n) {
        assertTrue( mainHW3.numberInInterval( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {25,10,100,222})
    void numberInIntervalFalse(int n) {
        assertFalse( mainHW3.numberInInterval( n ) );
    }
}
