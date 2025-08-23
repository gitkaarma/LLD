package Problems.DesignVendingMachine.exceptions;

/**
 * Exception thrown when requested item is not available or sold out
 */
public class ItemNotAvailableException extends VendingMachineException {
    
    private final int itemCode;
    
    public ItemNotAvailableException(int itemCode, String reason) {
        super(String.format("Item with code %d is not available: %s", itemCode, reason));
        this.itemCode = itemCode;
    }
    
    public int getItemCode() {
        return itemCode;
    }
}
