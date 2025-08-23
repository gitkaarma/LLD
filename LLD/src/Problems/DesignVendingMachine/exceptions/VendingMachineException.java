package Problems.DesignVendingMachine.exceptions;

/**
 * Base exception class for all vending machine related exceptions
 */
public class VendingMachineException extends Exception {
    
    public VendingMachineException(String message) {
        super(message);
    }
    
    public VendingMachineException(String message, Throwable cause) {
        super(message, cause);
    }
}
