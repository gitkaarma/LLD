package Problems.DesignVendingMachine.VendingStates.impl;

import Problems.DesignVendingMachine.Coin;
import Problems.DesignVendingMachine.Item;
import Problems.DesignVendingMachine.VendingMachine;
import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.exceptions.InvalidStateOperationException;
import Problems.DesignVendingMachine.exceptions.InsufficientFundsException;
import Problems.DesignVendingMachine.exceptions.ItemNotAvailableException;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

import java.util.List;


public class SelectionState implements State {

    public SelectionState(){
        VendingMachineLogger.info("Vending machine is now in SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot insert coins in Selection state");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws VendingMachineException {
        // Already in selection state, no action needed
        VendingMachineLogger.debug("Product selection button clicked - already in selection state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot insert coins in Selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        VendingMachineLogger.info("Product selected with code: " + codeNumber);
        
        try {
            // 1. Get item of this codeNumber
            Item item = machine.getInventory().getItem(codeNumber);
            
            // 2. Calculate total amount paid by user
            int paidByUser = machine.getTotalInsertedAmount();
            
            // 3. Compare product price and amount paid by user
            if (paidByUser < item.getPrice()) {
                VendingMachineLogger.warn("Insufficient funds - Required: " + item.getPrice() + ", Provided: " + paidByUser);
                refundFullMoney(machine);
                throw new InsufficientFundsException(item.getPrice(), paidByUser);
            } else {
                // Sufficient funds
                if (paidByUser > item.getPrice()) {
                    int changeAmount = paidByUser - item.getPrice();
                    getChange(changeAmount);
                }
                VendingMachineLogger.info("Payment successful, dispensing product...");
                machine.setVendingMachineState(new DispenseState(machine, codeNumber));
            }
        } catch (ItemNotAvailableException e) {
            VendingMachineLogger.error("Item not available: " + e.getMessage());
            refundFullMoney(machine);
            throw e;
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws VendingMachineException {
        // In a real implementation, this would return actual coins
        VendingMachineLogger.info("Change dispensed: " + returnExtraMoney + " units");
        return returnExtraMoney;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws VendingMachineException {
        List<Coin> refundedCoins = machine.getCoinList();
        VendingMachineLogger.info("Full refund processed - " + refundedCoins.size() + " coins returned");
        machine.setVendingMachineState(new IdleState(machine));
        return refundedCoins;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot dispense product in Selection state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot update inventory in Selection state");
    }

}
