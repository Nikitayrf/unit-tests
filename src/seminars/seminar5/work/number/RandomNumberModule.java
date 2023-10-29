package seminars.seminar5.work.number;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {
    public int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt();
        }
        return numbers;
    }
}
