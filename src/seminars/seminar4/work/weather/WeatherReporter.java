package seminars.seminar4.work.weather;

public class WeatherReporter {
    // Логика WeatherReporter завязана на логику WeatherService, т.е. есть внутренняя зависимость.
    // Что бы отвязаться от внутренних зависимостей необходимо создать mock-объект для WeatherService
    // т.е. сэмулировать работу WeatherService
    private WeatherService weatherService;

    // Внедрение зависимости через конструктор
    public WeatherReporter(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String generateReport() {
        int temperature = weatherService.getCurrentTemperature();
        return "Текущая температура: " + temperature + " градусов.";
    }
}
