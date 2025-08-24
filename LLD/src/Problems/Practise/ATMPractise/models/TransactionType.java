package Problems.Practise.ATMPractise.models;

public enum TransactionType {
    WITHDRAW_AMOUNT,
    CHECK_BALANCE;

    public static void printAllTransactions(){
        for(TransactionType transactionType: TransactionType.values()){
            System.out.println(transactionType.name());
        }
    }
}
