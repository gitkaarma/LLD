package Problems.BookMyShow.strategy.impl;

import Problems.BookMyShow.strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + String.format("%.2f", amount) + " to " + upiId);
        // Simulate a call to a real payment gateway
        return true;
    }
}
