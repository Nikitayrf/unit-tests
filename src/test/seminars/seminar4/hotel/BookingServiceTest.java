package seminars.seminar4.hotel;


import org.junit.jupiter.api.Test;
import seminars.seminar4.work.hotel.BookingService;
import seminars.seminar4.work.hotel.HotelService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    // 4.4.
    /**
     * Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
     * Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
     * который обычно проверяет, доступен ли номер в отеле.
     * Вам необходимо проверить правильность работы класса BookingService, который
     * использует HotelService для бронирования номера, если он доступен.
     */

    @Test
    void bookingServiceTest() {
        // Arrage (Подготовка)
        HotelService hotelService = mock(HotelService.class);
        when(hotelService.isRoomAvailable( 2 )).thenReturn( true );
        // Act (Выполнение)
        BookingService bookingService = new BookingService( hotelService );
        // Assert (Проверка выполнения)
        assertTrue(bookingService.bookRoom( 2 ));

    }
}