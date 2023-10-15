package lectures.lecture3;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();

        int result = calculation( firstOperand, secondOperand, operator );
        System.out.println( "Результат операции: " + result );
    }

    // Инициализация переменной scanner
    private static final Scanner scanner = new Scanner( System.in );

    // Метод принимает операцию от пользователя в виде символа
    public static char getOperator() {
        System.out.println( "Введите операцию:" );
        char operation = scanner.next().charAt( 0 );
        return operation;
    }

    // Метод принимает операнд от пользователя в виде числа
    public static int getOperand() {
        System.out.println( "Введите число:" );
        int operand;

        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println( "Вы допустили ошибку при вводе числа. Попробуйте ещё раз" );
            if (scanner.hasNextInt()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException( "Ошибка в вводимых данных" );
            }
        }
        return operand;
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
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException( "Division by zero is not possible" );
                }
            default:
                throw new IllegalStateException( "Unexpected value operator: " + operator );
        }
        return result;
    }


    // 1-ый этап 1.1д. Напишем метод заглушки, это нужно, что бы не сталкиваться с ошибками компиляции.
//    public static double computeAreaCircle(double radius) {
//        return 0;
//    }
    // 2-ой этап 2.1д. Рефакторинг основного кода (Refactoring)
//    public static double computeAreaCircle(double radius) {
//        return 3.14 * Math.pow( radius, 2 );
//    }

    // 2-ой этап 2.2д. Рефакторинг основного кода (Refactoring)
    public static double computeAreaCircle(double radius) {
        return Math.PI * Math.pow( radius, 2 );
    }
}