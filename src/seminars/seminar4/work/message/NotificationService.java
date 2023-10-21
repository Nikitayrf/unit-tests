package seminars.seminar4.work.message;

// Класс отвечает за уведомления
public class NotificationService {
    // Логика NotificationService завязана на логику MessageService, т.е. есть внутренняя зависимость.
    // Что бы отвязать от внутренних зависимостей NotificationService, необходимо создать mock-объект для NotificationService
    // т.е. сэмулировать работу NotificationService
    private MessageService messageService;  //

    // Внешняя зависимость от MessageService через конструктор
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    // Метод отправляющий сообщения, который вызывает sendMessage у messageService
    // Метод принимает сообщение message и получателя recipient.
    public void sendNotification(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
