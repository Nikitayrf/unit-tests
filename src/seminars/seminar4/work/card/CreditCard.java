package seminars.seminar4.work.card;

public class CreditCard {
    private String cardNumber;  // номер карты
    private String cardHolder;  // держатель карты
    private String expiryDate;  // конец действия карты
    private String cvv;  // защитный код карты

    public CreditCard(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    // Метод осуществляющий перевод, принимает значение amount (сумма перевода).
    public void charge(double amount) {
        System.out.println("Charged amount " + amount + " from the card: " + cardNumber);
    }
}

