package Problems.ATM.ATMStates.ConcreteStates;

import Problems.ATM.ATM;
import Problems.ATM.ATMStates.ATMState;
import Problems.ATM.Card;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());
    }

}
