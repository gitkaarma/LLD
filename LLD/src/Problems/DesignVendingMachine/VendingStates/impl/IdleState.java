package Problems.DesignVendingMachine.VendingStates.impl;

import Problems.DesignVendingMachine.Coin;
import Problems.DesignVendingMachine.Item;
import Problems.DesignVendingMachine.VendingMachine;
import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.exceptions.InvalidStateOperationException;
import Problems.DesignVendingMachine.exceptions.ItemNotAvailableException;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        VendingMachineLogger.info("Vending machine is now in IdleState");
    }

    public IdleState(VendingMachine machine){
        VendingMachineLogger.info("Vending machine is now in IdleState");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws VendingMachineException {
        VendingMachineLogger.info("Insert coin button clicked - transitioning to HasMoneyState");
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("Please insert coins first before selecting a product");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws VendingMachineException {
        throw new InvalidStateOperationException("Please click insert coin button first");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot choose product in idle state - please insert coins first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot get change in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws VendingMachineException {
        throw new InvalidStateOperationException("No money to refund in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException {
        throw new InvalidStateOperationException("Cannot dispense product in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws VendingMachineException {
        try {
            machine.getInventory().addItem(item, codeNumber);
        } catch (ItemNotAvailableException e) {
            throw e;
        }
    }
}
