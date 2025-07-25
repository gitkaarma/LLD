package Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors;

import Problems.ATM.ATM;
import Problems.ATM.AmountWithdrawal.CashWithdrawalProcessor;

import java.util.Objects;

public class TwoHundredRupeeProcessor extends CashWithdrawalProcessor {
    public TwoHundredRupeeProcessor(){
        this.denomination = 200;
    }
    @Override
    public void processAmount(ATM atm, int amount) {
        int required = amount/denomination, remaining = amount%denomination;
        if(required <= atm.getTwoHundredRupeeNotes()){
            System.out.println("Dispensing " + required + " 200 rupee notes!");
            atm.setTwoHundredRupeeNotes(atm.getTwoHundredRupeeNotes() - required);
        }else{
            System.out.println("Dispensing " + atm.getTwoHundredRupeeNotes() + " 200 rupee notes!");
            remaining = amount - atm.getTwoHundredRupeeNotes()*denomination;
            atm.setTwoHundredRupeeNotes(0);
        }
        if(Objects.nonNull(this.nextCashWithdrawalProcessor)){
            this.nextCashWithdrawalProcessor.processAmount(atm, remaining);
        }
    }
}
