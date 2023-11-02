package seminars.seminar5.work.number;

import java.util.List;

public class MaxNumberModule {
    public int findMaxNumber(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }
}
