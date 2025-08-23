package Problems.DesignVendingMachine;

import Problems.DesignVendingMachine.exceptions.ItemNotAvailableException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

public class Inventory {

    private ItemShelf[] inventory;

    Inventory(int itemCount) {
        if (itemCount <= 0) {
            throw new IllegalArgumentException("Item count must be positive");
        }
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
        VendingMachineLogger.debug("Inventory initialized with " + itemCount + " slots");
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    private void initializeEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }
    
    /**
     * Validates if the given code number exists in inventory
     */
    private boolean isValidCodeNumber(int codeNumber) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getCode() == codeNumber) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Find shelf by code number
     */
    private ItemShelf findShelfByCode(int codeNumber) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getCode() == codeNumber) {
                return shelf;
            }
        }
        return null;
    }

    public void addItem(Item item, int codeNumber) throws ItemNotAvailableException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        
        if (!isValidCodeNumber(codeNumber)) {
            throw new ItemNotAvailableException(codeNumber, "Invalid code number");
        }
        
        ItemShelf shelf = findShelfByCode(codeNumber);
        if (shelf != null) {
            if (shelf.isSoldOut()) {
                shelf.setItem(item);
                shelf.setSoldOut(false);
                VendingMachineLogger.info("Item added to slot " + codeNumber + ": " + item.getType().name());
            } else {
                throw new ItemNotAvailableException(codeNumber, "Slot already occupied");
            }
        }
    }

    public Item getItem(int codeNumber) throws ItemNotAvailableException {
        if (!isValidCodeNumber(codeNumber)) {
            throw new ItemNotAvailableException(codeNumber, "Invalid code number");
        }
        
        ItemShelf shelf = findShelfByCode(codeNumber);
        if (shelf != null) {
            if (shelf.isSoldOut()) {
                throw new ItemNotAvailableException(codeNumber, "Item sold out");
            } else {
                return shelf.getItem();
            }
        }
        throw new ItemNotAvailableException(codeNumber, "Item not found");
    }

    public void updateSoldOutItem(int codeNumber) {
        ItemShelf shelf = findShelfByCode(codeNumber);
        if (shelf != null) {
            shelf.setSoldOut(true);
            VendingMachineLogger.info("Item at slot " + codeNumber + " marked as sold out");
        }
    }
    
    /**
     * Check if item is available at given code
     */
    public boolean isItemAvailable(int codeNumber) {
        ItemShelf shelf = findShelfByCode(codeNumber);
        return shelf != null && !shelf.isSoldOut() && shelf.getItem() != null;
    }
    
    /**
     * Get count of available items
     */
    public int getAvailableItemCount() {
        int count = 0;
        for (ItemShelf shelf : inventory) {
            if (!shelf.isSoldOut() && shelf.getItem() != null) {
                count++;
            }
        }
        return count;
    }
}
