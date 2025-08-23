package Problems.DesignVendingMachine.VendingStates;

import Problems.DesignVendingMachine.Coin;
import Problems.DesignVendingMachine.Item;
import Problems.DesignVendingMachine.VendingMachine;
import Problems.DesignVendingMachine.exceptions.VendingMachineException;

import java.util.List;

public interface State {

    void clickOnInsertCoinButton(VendingMachine machine) throws VendingMachineException;

    void clickOnProductSelectionButton(VendingMachine machine) throws VendingMachineException;

    void insertCoin(VendingMachine machine, Coin coin) throws VendingMachineException;

    void chooseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException;

    int getChange(int returnChangeMoney) throws VendingMachineException;

    Item dispenseProduct(VendingMachine machine, int codeNumber) throws VendingMachineException;

    List<Coin> refundFullMoney(VendingMachine machine) throws VendingMachineException;

    void updateInventory(VendingMachine machine, Item item, int codeNumber) throws VendingMachineException;
}
