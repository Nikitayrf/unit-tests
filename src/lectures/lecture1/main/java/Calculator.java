package lectures.lecture1.main.java;

public class Calculator {
    public static void main(String[] args) {
        // Ручное тестирование выдаёт ожидаемый результат. Можно проверить метод таким образом,
        // но эти проверки занимают много времени и плохо масштабируется.
        System.out.printf( "Результат операции: %s\n", calculation( 2, 2, '+' ) );  // Результат операции: 4
        System.out.printf( "Результат операции: %s\n", calculation( 4, 2, '-' ) );  // Результат операции: 2
        System.out.printf( "Результат операции: %s\n", calculation( 8, 2, '/' ) );  // Результат операции: 4
        System.out.printf( "Результат операции: %s\n", calculation( 3, 2, '*' ) );  // Результат операции: 6

//        System.out.printf( "Результат операции: %s\n", calculation( 3, 2, '_' ) );  // Неожиданный результат. Результат операции: 0
//        System.out.printf( "Результат операции: %s\n", calculation( 8, 0, '/' ) );  // Exception in thread "main" java.lang.ArithmeticException: / by zero
//        System.out.printf( "Результат операции: %s\n", calculation( 234234214343, 2, '/' ) );  // Невозможно из-за статического анализатора Idea
        System.out.printf( "Результат операции: %s\n", calculation( 234234255, 10, '_' ) );  // Неверный результат. Результат операции: -1952624746
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0){
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }
}