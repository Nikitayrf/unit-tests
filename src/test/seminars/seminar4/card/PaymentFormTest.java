package seminars.seminar4.card;

import org.junit.jupiter.api.Test;
import seminars.seminar4.work.card.CreditCard;
import seminars.seminar4.work.card.PaymentForm;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    void paymentFormTest() {
        // Arrage (Подготовка)
        CreditCard creditCard = mock( CreditCard.class );
        when( creditCard.getCardNumber() ).thenReturn( "1230980980" );
        when( creditCard.getCardHolder() ).thenReturn( "Nikita Petrov" );
        when( creditCard.getExpiryDate() ).thenReturn( "01/2025" );
        when( creditCard.getCvv() ).thenReturn( "883" );
        PaymentForm paymentForm = new PaymentForm( creditCard );
        // Act (Выполнение)
        paymentForm.pay( 100 );
        // Assert (Проверка утверждение)
        verify( creditCard, times( 1 ) ).charge( 100 );
    }



}