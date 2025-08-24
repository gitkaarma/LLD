package Problems.Practise.ATMPractise.models;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("This function is currently unavailable!");
    }
    public void authenticatePin(ATM atm, Card card, Integer enteredPin){
        System.out.println("This function is currently unavailable");
    }

    public void withDrawCash(ATM atm, Card card, Integer amountToWithDraw){
        System.out.println("This function is currently unavailable");
    }

    public void checkBalance(ATM atm, Card card){
        System.out.println("This function is currently unavailable");
    }

    public void selectOperation(ATM atm, TransactionType transactionType){
        System.out.println("This function is currently unavailable");
    }

    public void returnCard(ATM atm){
        System.out.println("You can collect your card now!");
    }
    public void exit(ATM atm){

    }
}
