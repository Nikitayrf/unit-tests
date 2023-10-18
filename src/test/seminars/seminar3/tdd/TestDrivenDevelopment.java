package seminars.seminar3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDrivenDevelopment {

    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUP() {
        moodAnalyser = new MoodAnalyser();
    }

    // 3.5. Red-Green-Refactor

    /**
     * Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
     * выраженное во фразах.
     */

    @Test
    void analyseMoodBad() {
        assertThat( moodAnalyser.analyseMood( "I am very unlucky" ) ).contains( "bad" );
    }

    @Test
    void analyseMoodNormal() {
        assertThat( moodAnalyser.analyseMood( " I am very incomprehensible" ) ).contains( "normal" );
    }

    @Test
    void analyseMoodGood() {
        assertThat( moodAnalyser.analyseMood( " I am very happy" ) ).contains( "good" );
    }

    @Test
    void analyseMoodResumeMoodNotClear() {
        assertThat( moodAnalyser.analyseMood( "Hello world" ) ).contains( "mood not clear" );
    }
}
