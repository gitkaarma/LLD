package Problems.ParkingLot.PaymentStrategy.impl;

import Problems.ParkingLot.PaymentStrategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Amount " + amount + "was processed using credit card!! Voila");
    }
}
