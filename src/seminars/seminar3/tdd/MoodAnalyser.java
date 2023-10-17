package seminars.seminar3.tdd;

import java.util.Arrays;
import java.util.List;

public class MoodAnalyser {

    public String analyseMood(String message) {
        message = message.toLowerCase();

        List<String> badMoods = Arrays.asList( "sad", "not happy", "unlucky" );
        List<String> normalMoods = Arrays.asList( "normal", "incomprehensible" );
        List<String> goodMoods = Arrays.asList( "good", "happy", "lucky" );


        for (String badMood : badMoods) {
            if (message.contains( badMood )) {
                return "bad";
            }
        }
        for (String normalMood : normalMoods) {
            if (message.contains( normalMood )) {
                return "normal";
            }
        }
        for (String goodMood : goodMoods)
            if (message.contains( goodMood )) {
                return "good";
            }
        return "mood not clear";

    }
}