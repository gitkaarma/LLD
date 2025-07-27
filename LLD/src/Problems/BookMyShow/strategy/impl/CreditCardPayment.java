package Problems.BookMyShow.strategy.impl;

import Problems.BookMyShow.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String name;
    private final String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment of ₹" + String.format("%.2f", amount) + " for " + name);
        // Simulate a call to a real payment gateway
        return true;
    }
}
