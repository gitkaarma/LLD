package Problems.DesignVendingMachine.VendingStates.impl;

import Problems.DesignVendingMachine.Coin;
import Problems.DesignVendingMachine.Item;
import Problems.DesignVendingMachine.VendingMachine;
import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.exceptions.InvalidStateOperationException;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState(){
        VendingMachineLogger.info("Vending machine is now in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws VendingMachineException {
        // Already in money state, no action needed
        VendingMachineLogger.debug("Insert coin button clicked - already in HasMoneyState");
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws VendingMachineException {
        VendingMachineLogger.info("Product selection button clicked - transitioning to SelectionState");
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws VendingMachineException {
        if (coin == null) {
            throw new IllegalArgumentException("Coin cannot be null");
        }
        machine.addCoin(coin);
        VendingMachineLogger.info("Coin accepted: " + coin.name() + " (value: " + coin.value + ")");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Please click product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot get change in HasMoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot dispense product in HasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws VendingMachineException {
        List<Coin> refundedCoins = machine.getCoinList();
        VendingMachineLogger.info("Full refund processed - " + refundedCoins.size() + " coins returned");
        machine.setVendingMachineState(new IdleState(machine));
        return refundedCoins;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot update inventory in HasMoney state");
    }
}
