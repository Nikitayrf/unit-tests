package seminars.seminar4.work.card;

public class PaymentForm {
    // Логика PaymentForm завязана на логику CreditCard, т.е. есть внутренние зависимости.
    // Что бы отвязаться от внутренних зависимостей необходимо создать mock-объект для CreditCard
    // т.е. сэмулировать работу CreditCard
    private CreditCard creditCard;  // объект CreditCard

    public PaymentForm(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // Метод оплаты
    public void pay(double amount) {
        creditCard.charge(amount);
    }
}
