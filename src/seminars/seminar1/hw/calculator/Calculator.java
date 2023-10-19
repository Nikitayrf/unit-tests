package seminars.seminar1.hw.calculator;


public class Calculator {
    public static void main(String[] args) {
        System.out.printf( "Сумма покупок с учётом скидки: %s\n", calculateDiscount( 4000, 10 ) );

    }

    public static int calculateDiscount(int purchaseAmount, int discount) {
        int result;
        if (discount >= 100) {
            throw new ArithmeticException( "Скидка должна быть меньше 100%" );
        } else if (discount < 0) {
            throw new ArithmeticException( "Скидка не может быть отрицательной" );
        } else if (purchaseAmount <= 0) {
            throw new ArithmeticException( "Сумма покупок должна быть больше 0" );
        } else {
            result = purchaseAmount - (purchaseAmount * discount / 100);

        }
        return result;
    }
}
