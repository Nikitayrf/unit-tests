package seminars.seminar4;

import org.junit.jupiter.api.Test;
import seminars.seminar4.work.card.CreditCard;
import seminars.seminar4.work.card.PaymentForm;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.mockito.Mockito.*;


class MainTest {

    /**
     * 4.0. Проверка работы Mockito
     */
    @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock( List.class );

        // Используем мок
        mockedList.add( "one" );
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify( mockedList ).add( "one" );
        verify( mockedList ).clear();
    }

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
    @Test
    public void iteratorWillReturnHelloWorld() {
        // Arrage (Подготовка)
        Iterator iteratorMock = mock( Iterator.class );
        when( iteratorMock.next() ).thenReturn( "Hello" ).thenReturn( "World" );
        // Act (Выполнение)
        String result = iteratorMock.next() + " " + iteratorMock.next();
        // Assert (Проверка утверждение)
        assertThat( result ).isEqualTo( "Hello World" );
    }
}