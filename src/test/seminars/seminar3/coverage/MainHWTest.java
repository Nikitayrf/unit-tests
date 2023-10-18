package seminars.seminar3.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.seminar3.hw.MainHW;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    void setUP() {
        mainHW = new MainHW();
    }

    // 3.1. Homework3

    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * переданное число четным или нечетным
     */

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void evenOddNumberTrue(int n) {
        assertTrue( mainHW.evenOddNumber( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void evenOddNumberFalse(int n) {
        assertFalse( mainHW.evenOddNumber( n ) );
    }

    // 3.2. homework3

    /**
     * Разработайте и протестируйте метод numberInInterval, который проверяет,
     * попадает ли переданное число в интервал (25;100)
     */

    @ParameterizedTest
    @ValueSource(ints = {26, 30, 99})
    void numberInIntervalTrue(int n) {
        assertTrue( mainHW.numberInInterval( n ) );
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 10, 100, 222})
    void numberInIntervalFalse(int n) {
        assertFalse( mainHW.numberInInterval( n ) );
    }
}
