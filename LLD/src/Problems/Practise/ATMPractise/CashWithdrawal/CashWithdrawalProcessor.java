package Problems.Practise.ATMPractise.CashWithdrawal;

import Problems.Practise.ATMPractise.models.ATM;

public abstract class CashWithdrawalProcessor {
    protected Integer denomination;
    protected CashWithdrawalProcessor nextCashWithdrawalProcessor;
    public void setNextProcessor(CashWithdrawalProcessor cashWithdrawalProcessor){
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }
    public abstract void processAmount(ATM atm, Integer amount);
}
