package seminars.seminar4.message;


import org.junit.jupiter.api.Test;
import seminars.seminar4.work.message.MessageService;
import seminars.seminar4.work.message.NotificationService;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    /**
     * Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
     * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
     * recipient), который отправляет сообщение получателю.
     * Вам необходимо проверить правильность работы класса NotificationService, который использует
     * MessageService для отправки уведомлений
     */
    @Test
    void notificationServiceTest() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService( messageService );
        notificationService.sendNotification("hello", "oleg");
        verify( messageService, times( 1 ) ).sendMessage(  "hello", "oleg");
    }
}