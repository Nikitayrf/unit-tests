package seminars.seminar1;


import java.util.Calendar;

public class task4 {
    public static void main(String[] args) {
        happyNY();
    }

    public static void happyNY() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.getWeekYear();
        assert year >= 2023 : "Ещё не наступил Новый год";
        System.out.println( "С новым годом!" );
    }
}

