package Problems.DesignVendingMachine;

import Problems.DesignVendingMachine.VendingStates.State;
import Problems.DesignVendingMachine.VendingStates.impl.IdleState;
import Problems.DesignVendingMachine.utils.VendingMachineLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;
    private final int maxInventorySize;

    public VendingMachine(){
        this(10); // Default inventory size
    }
    
    public VendingMachine(int inventorySize){
        if (inventorySize <= 0) {
            throw new IllegalArgumentException("Inventory size must be positive");
        }
        this.maxInventorySize = inventorySize;
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(inventorySize);
        this.coinList = new ArrayList<>();
        VendingMachineLogger.info("Vending machine initialized with inventory size: " + inventorySize);
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return Collections.unmodifiableList(coinList);
    }

    public void setCoinList(List<Coin> coinList) {
        if (coinList == null) {
            this.coinList = new ArrayList<>();
        } else {
            this.coinList = new ArrayList<>(coinList);
        }
    }
    
    /**
     * Calculate total amount from inserted coins
     */
    public int getTotalInsertedAmount() {
        return coinList.stream().mapToInt(coin -> coin.value).sum();
    }
    
    /**
     * Add a coin to the machine
     */
    public void addCoin(Coin coin) {
        if (coin != null) {
            coinList.add(coin);
            VendingMachineLogger.debug("Coin added: " + coin.name() + " (value: " + coin.value + ")");
        }
    }
    
    /**
     * Clear all inserted coins
     */
    public void clearCoins() {
        coinList.clear();
        VendingMachineLogger.debug("All coins cleared");
    }
    
    public int getMaxInventorySize() {
        return maxInventorySize;
    }
}
