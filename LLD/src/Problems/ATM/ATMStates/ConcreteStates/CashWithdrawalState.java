package Problems.ATM.ATMStates.ConcreteStates;

import Problems.ATM.ATM;
import Problems.ATM.ATMStates.ATMState;
import Problems.ATM.AmountWithdrawal.CashWithdrawalProcessor;
import Problems.ATM.AmountWithdrawal.CashWithdrawalProcessorChain;
import Problems.ATM.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {

        if (atmObject.getTotalAmount() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.setTotalAmount(atmObject.getTotalAmount() - withdrawalAmountRequest);
            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawalProcessor withdrawProcessor = CashWithdrawalProcessorChain.getCashWithdrawalProcessor();

            withdrawProcessor.processAmount(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
