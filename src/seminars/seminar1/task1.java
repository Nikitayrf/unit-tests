package seminars.seminar1;

public class task1 {
    public static void main(String[] args) {
        assertConditionA();
    }
    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дни выходных");

    }
}
