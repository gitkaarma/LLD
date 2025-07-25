package Problems.ATM.AmountWithdrawal;

import Problems.ATM.ATM;

public abstract class CashWithdrawalProcessor {
    protected CashWithdrawalProcessor nextCashWithdrawalProcessor;
    protected int denomination;

    public void setNextCashWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor){
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }
    public abstract void processAmount(ATM atm, int amount);

}
