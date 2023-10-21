package seminars.seminar4.work.hotel;

public class BookingService {
    // Логика BookingService завязана на логику HotelService, т.е. есть внутренняя зависимость.
    // Что бы отвязаться от внутренних зависимостей необходимо создать mock-объект для BookingService
    // т.е. сэмулировать работу BookingService
    private HotelService hotelService;

    // Внешняя зависимость через конструктор
    public BookingService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public boolean bookRoom(int roomId) {
        if (hotelService.isRoomAvailable(roomId)) {
            // Код, который бронирует номер.
            // Логика бронирования комнаты
            // В реальном приложении здесь бы было больше кода
            return true; // Номер забронирован
        } else {
            return false; // Номер не доступен
        }
    }

}
