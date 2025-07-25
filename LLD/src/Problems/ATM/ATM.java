package Problems.ATM;

import Problems.ATM.ATMStates.ATMState;
import Problems.ATM.ATMStates.ConcreteStates.IdleState;

public class ATM {
    private int hundredRupeeNotes;
    private int thousandRupeeNotes;
    private int twoHundredRupeeNotes;

    private int totalAmount;
    private ATMState atmState;
    private static ATM atm;

    private ATM() {
    }
    public static ATM getATMObject() {
        atm = new ATM();
        atm.setAtmState(new IdleState());
        return atm;
    }

    public void setAtmBalance(int atmBalance, int thousandRupeeNotes, int twoHundredRupeeNotes, int hundredRupeeNotes) {
        this.totalAmount = atmBalance;
        this.thousandRupeeNotes = thousandRupeeNotes;
        this.twoHundredRupeeNotes = twoHundredRupeeNotes;
        this.hundredRupeeNotes = hundredRupeeNotes;
    }


    public int getHundredRupeeNotes() {
        return hundredRupeeNotes;
    }

    public void setHundredRupeeNotes(int hundredRupeeNotes) {
        this.hundredRupeeNotes = hundredRupeeNotes;
    }

    public int getThousandRupeeNotes() {
        return thousandRupeeNotes;
    }

    public void setThousandRupeeNotes(int thousandRupeeNotes) {
        this.thousandRupeeNotes = thousandRupeeNotes;
    }

    public int getTwoHundredRupeeNotes() {
        return twoHundredRupeeNotes;
    }

    public void setTwoHundredRupeeNotes(int twoHundredRupeeNotes) {
        this.twoHundredRupeeNotes = twoHundredRupeeNotes;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + totalAmount);
        System.out.println("1kNotes: " + thousandRupeeNotes);
        System.out.println("200Notes: " + twoHundredRupeeNotes);
        System.out.println("100Notes: " + hundredRupeeNotes);

    }


}
