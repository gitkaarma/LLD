package Problems.Practise.ATMPractise.models;

import Problems.ATM.BankAccount;

import java.util.concurrent.ThreadLocalRandom;

public class Card {
    public Integer getPIN() {
        return PIN;
    }

    public void setPIN(Integer PIN) {
        this.PIN = PIN;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }
    public Card(BankAccount bankAccount){
        this.cardNumber = ThreadLocalRandom.current().nextInt(100000, 1000000);
        this.CVV = ThreadLocalRandom.current().nextInt(100, 1000);
        this.PIN = ThreadLocalRandom.current().nextInt(100000, 1000000);
        this.bankAccount = bankAccount;
    }
    private Integer PIN;
    private Integer cardNumber;
    private Integer CVV;
    private BankAccount bankAccount;


}
