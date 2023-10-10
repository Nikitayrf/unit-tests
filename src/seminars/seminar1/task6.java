package seminars.seminar1;


import static org.assertj.core.api.Assertions.*;


public class task6 {
    public static void main(String[] args) {
        expectedValue();
    }

    public static void expectedValue() {
        assertThat(Integer.sum(2, 3)).isEqualTo( 5 );
    }
}
