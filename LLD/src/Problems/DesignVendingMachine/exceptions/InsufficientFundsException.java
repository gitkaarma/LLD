package Problems.DesignVendingMachine.exceptions;

/**
 * Exception thrown when user doesn't have sufficient funds for selected item
 */
public class InsufficientFundsException extends VendingMachineException {
    
    private final int requiredAmount;
    private final int providedAmount;
    
    public InsufficientFundsException(int requiredAmount, int providedAmount) {
        super(String.format("Insufficient funds. Required: %d, Provided: %d", requiredAmount, providedAmount));
        this.requiredAmount = requiredAmount;
        this.providedAmount = providedAmount;
    }
    
    public int getRequiredAmount() {
        return requiredAmount;
    }
    
    public int getProvidedAmount() {
        return providedAmount;
    }
}
