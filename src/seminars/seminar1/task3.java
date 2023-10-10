package seminars.seminar1;

public class task3 {

    public static void main(String[] args) {
        System.out.println( summ( 1, Integer.MAX_VALUE ) );
    }

    public static int summ(int a, int b) {
        assert Integer.MAX_VALUE - Math.abs( a ) >= Math.abs( b ) : "Ошибка, вышли за пределы целых чисел";
        return a + b;
    }
}

