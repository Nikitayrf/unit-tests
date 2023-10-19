package seminars.seminar2.hw;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

public class VehicleTest {

    /**
     * Проверить, что экземпляр объекта Car также является
     * экземпляром транспортного средства
     * (используя оператор instanceof).
     */

    @Test
    void isVehicle() {
        // Arrange (Подготовка)
        Car car = new Car( "LADA", "Vesta", 2006 );
        // Assert (Проверка утверждение)
        assertThat( car instanceof Vehicle ).isEqualTo( true );
    }

    /**
     * - Проверить, что объект Car создается с 4-мя колесами.
     */

    @Test
    void numWheelsCar() {
        // Arrange (Подготовка)
        Car car = new Car( "LADA", "Vesta", 2006 );
        // Assert (Проверка утверждение)
        assertThat( car.getNumWheels() ).isEqualTo( 4 );

    }

    /**
     * - Проверить, что объект Motorcycle создается с 2-мя колесами.
     */

    @Test
    void numWheelsMotorcycle() {
        // Arrage (Подготовка)
        Motorcycle motorcycle = new Motorcycle( " Ish", "21-001", 2000 );
        // Assert (Проверка утверждения)
        assertThat( motorcycle.getNumWheels() ).isEqualTo( 2 );
    }

    /**
     * - Проверить, что объект Car развивает скорость 60
     * в режиме тестового вождения (используя метод testDrive())
     */

    @Test
    void carSpeedtestDrive() {
        // Arrage (Подготовка)
        Car car = new Car( "LADA", "Vesta", 2006 );
        // Act (Выполнение)
        car.testDrive();
        // Assert (Проверка утверждение)
        assertThat( car.getSpeed() ).isEqualTo( 60 );
    }

    /**
     * - Проверить, что объект Motorcycle развивает скорость 75
     * в режиме тестового вождения (используя метод testDrive()).
     */

    @Test
    void motorcycleSpeedTestDrive() {
        // Arrage (Подготовка)
        Motorcycle motorcycle = new Motorcycle( " Ish", "21-001", 2000 );
        // Act (Выполнение)
        motorcycle.testDrive();
        // Assert (Проверка утверждения)
        assertThat( motorcycle.getSpeed() ).isEqualTo( 75 );
    }

    /**
     * - Проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */

    @Test
    void carSpeedPark() {
        // Arrage (Подготовка)
        Car car = new Car( "LADA", "Vesta", 2006 );
        // Act (Выполнение)
        car.testDrive();
        car.park();
        // Assert (Проверка утверждения)
        assertThat( car.getSpeed() ).isEqualTo( 0 );
    }

    /**
     * - Проверить, что в режиме парковки (сначала testDrive, потом park,
     * т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */

    @Test
    void motorcycleSpeedPark() {
        // Arrage (Подготовка)
        Motorcycle motorcycle = new Motorcycle( " Ish", "21-001", 2000 );
        // Act (Выполнение)
        motorcycle.testDrive();
        motorcycle.park();
        // Assert (Проверка утверждения)
        assertThat( motorcycle.getSpeed() ).isEqualTo( 0 );
    }


}
