package Problems.DesignVendingMachine.exceptions;

/**
 * Exception thrown when an invalid operation is attempted in current state
 */
public class InvalidStateOperationException extends VendingMachineException {
    
    public InvalidStateOperationException(String message) {
        super(message);
    }
}
