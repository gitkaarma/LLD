package Problems.ATM.ATMStates.ConcreteStates;

import Problems.ATM.ATM;
import Problems.ATM.ATMStates.ATMState;
import Problems.ATM.Card;

public class HasCardState extends ATMState {

    public HasCardState(){
        System.out.println("enter your card pin number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

        if(isCorrectPinEntered) {
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
