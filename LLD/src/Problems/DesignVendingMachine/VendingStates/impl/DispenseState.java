package Problems.DesignVendingMachine.VendingStates.impl;

import Problems.DesignVendingMachine.Coin;
import Problems.DesignVendingMachine.Item;
import Problems.DesignVendingMachine.VendingMachine;
import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.exceptions.InvalidStateOperationException;
import Problems.DesignVendingMachine.exceptions.ItemNotAvailableException;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine machine, int codeNumber) throws VendingMachineException {
        VendingMachineLogger.info("Vending machine is now in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot insert coins while dispensing product");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot select product while dispensing");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot insert coins while dispensing product");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot choose product while dispensing");
    }

    @Override
    public int getChange(int returnChangeMoney) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot get change while dispensing product");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot refund money while dispensing product");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        try {
            Item item = machine.getInventory().getItem(codeNumber);
            machine.getInventory().updateSoldOutItem(codeNumber);
            VendingMachineLogger.info("Product dispensed: " + item.getType().name() + " from slot " + codeNumber);
            machine.setVendingMachineState(new IdleState(machine));
            return item;
        } catch (ItemNotAvailableException e) {
            VendingMachineLogger.error("Failed to dispense product: " + e.getMessage());
            machine.setVendingMachineState(new IdleState(machine));
            throw e;
        }
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot update inventory while dispensing product");
    }
}
