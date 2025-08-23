package Problems.DesignVendingMachine;

import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

public class Main {

    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
           // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (VendingMachineException e) {
            VendingMachineLogger.error("Vending machine error: " + e.getMessage());
            displayInventory(vendingMachine);
        } catch (Exception e) {
            VendingMachineLogger.error("Unexpected error: " + e.getMessage());
            displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            try {
                Item newItem;
                if (i >= 0 && i < 3) {
                    newItem = new Item(ItemType.COKE, 12);
                } else if (i >= 3 && i < 5) {
                    newItem = new Item(ItemType.PEPSI, 9);
                } else if (i >= 5 && i < 7) {
                    newItem = new Item(ItemType.JUICE, 13);
                } else if (i >= 7 && i < 10) {
                    newItem = new Item(ItemType.SODA, 7);
                } else {
                    continue; // Skip if out of range
                }
                
                vendingMachine.getInventory().addItem(newItem, slots[i].getCode());
                VendingMachineLogger.debug("Added item to slot " + slots[i].getCode() + ": " + newItem.getType().name());
            } catch (Exception e) {
                VendingMachineLogger.error("Failed to add item to slot " + slots[i].getCode() + ": " + e.getMessage());
            }
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }
}
