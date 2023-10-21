package seminars.seminar4.weather;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import seminars.seminar4.work.weather.WeatherReporter;
import seminars.seminar4.work.weather.WeatherService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WeatherReporterTest {

    /**
     * Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
     * обращающийся к внешнему API для получения информации о текущей температуре.
     * Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
     * Создайте мок-объект для WeatherService с использованием Mockito.
     */

    @Test
    void weatherReporterTest() {
        // Arrage (Подготовка)
        WeatherService weatherService = mock(WeatherService.class);
        when( weatherService.getCurrentTemperature() ).thenReturn( 20 );
        // Act (Выполнение)
        WeatherReporter weatherReporter = new WeatherReporter( weatherService );
        // Assert (Проверка утверждение)
        assertThat(weatherReporter.generateReport()).isEqualTo( "Текущая температура: " + 20 + " градусов." );
    }

}