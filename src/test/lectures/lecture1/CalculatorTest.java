package lectures.lecture1;//import lectures.lecture2.main.java.Calculator;  // Для третей лекции переопределить импорт класса
import lectures.lecture3.Calculator;  // Для третей лекции добавить импорт класса
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    // Тест для сложения
    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat( calculator.calculation( 2, 6, '+' ) ).isEqualTo( 8 );
    }

    // Тест для вычитания
    @Test
    void subsctractionExpression() {
        Calculator calculator = new Calculator();
        assertThat( calculator.calculation( 2, 1, '-' ) ).isEqualTo( 1 );
    }

    // Тест для умножения
    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat( calculator.calculation( 2, 4, '*' ) ).isEqualTo( 8 );
    }

    // Тест для деления
    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat( calculator.calculation( 8, 2, '/' ) ).isEqualTo( 4 );
    }

    // Тест если в метод передан не правильный оператор
    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy( () -> calculator.calculation( 8, 4, '_' ) )
                .isInstanceOf( IllegalStateException.class );
    }

    // Тест проверки, что метод отрабатывает корректно, если в метод передано число
    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(  testedValue.getBytes());
        InputStream inputStream = System.in; // сохраним ссылку на ввод с клавиатуры
        System.setIn( in ); // подмена ввода

        Calculator.getOperand();

        System.out.println(testedValue);

        System.setIn( inputStream );  // подмена ссылки на ввод с клавиатуры обратно

    }

    // Тест проверки, если в метод пришёл символ буквы
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream( testedValue.getBytes() );
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn( in );
        System.setOut( new PrintStream( out ) );

        assertThatThrownBy( () -> Calculator.getOperand() ).isInstanceOf( IllegalStateException.class )
                .describedAs( "Ошибка в вводимых данных" );

        System.setIn( inputStream );
        System.setOut( null );
    }

    // 1.2д. Создадим неудачный тест для метода заглушки.
    @Test
    void computerCircleRadiusWorksCorrectly() {
        assertThat( Calculator.computeAreaCircle(  10)).isEqualTo(  314.1592653589793);
    }
}
