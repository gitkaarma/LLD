package Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors;

import Problems.ATM.ATM;
import Problems.ATM.AmountWithdrawal.CashWithdrawalProcessor;

import java.util.Objects;

public class HundredRupeeProcessor extends CashWithdrawalProcessor {
    public HundredRupeeProcessor(){
        this.denomination = 100;
    }
    @Override
    public void processAmount(ATM atm, int amount) {
        int required = amount/denomination, remaining = amount%denomination;
        if(required <= atm.getHundredRupeeNotes()){
            System.out.println("Dispensing " + required + " 100 rupee notes!");
            atm.setHundredRupeeNotes(atm.getHundredRupeeNotes() - required);
        }else{
            System.out.println("Dispensing " + atm.getHundredRupeeNotes() + " 100 rupee notes!");
            remaining = amount - atm.getHundredRupeeNotes()*denomination;
            atm.setHundredRupeeNotes(0);
        }
        if(Objects.nonNull(this.nextCashWithdrawalProcessor)){
            this.nextCashWithdrawalProcessor.processAmount(atm, remaining);
        }
    }
}
