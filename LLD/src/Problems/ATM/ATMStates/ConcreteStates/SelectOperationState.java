package Problems.ATM.ATMStates.ConcreteStates;

import Problems.ATM.ATM;
import Problems.ATM.ATMStates.ATMState;
import Problems.ATM.Card;
import Problems.ATM.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState(){
        showOperations();
    }

    @Override
    public void selectOperation(ATM atmObject, Card card, TransactionType txnType){

        switch (txnType) {

            case CASH_WITHDRAWAL:
                atmObject.setAtmState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atmObject.setAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atmObject);
            }

        }
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
