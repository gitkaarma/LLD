package Problems.Practise.ATMPractise.CashWithdrawal.ConcreteCashWithdrawalProcessor;

import Problems.Practise.ATMPractise.CashWithdrawal.CashWithdrawalProcessor;
import Problems.Practise.ATMPractise.models.ATM;

public class ThousandRupeeProcessor extends CashWithdrawalProcessor {
    public ThousandRupeeProcessor(){
        this.denomination = Integer.valueOf(1000);
    }
    @Override
    public void processAmount(ATM atm, Integer amount) {

    }
}
