package Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors;

import Problems.ATM.ATM;
import Problems.ATM.AmountWithdrawal.CashWithdrawalProcessor;

import java.util.Objects;

public class ThousandRupeeProcessor extends CashWithdrawalProcessor {

    public ThousandRupeeProcessor(){
        this.denomination = 1000;
    }
    @Override
    public void processAmount(ATM atm, int amount) {
        int required = amount/denomination, remaining = amount%denomination;
        if(required <= atm.getThousandRupeeNotes()){
            System.out.println("Dispensing " + required + " 1000 rupee notes!");
            atm.setThousandRupeeNotes(atm.getThousandRupeeNotes() - required);
        }else{
            System.out.println("Dispensing " + atm.getThousandRupeeNotes() + " 1000 rupee notes!");
            remaining = amount - atm.getThousandRupeeNotes()*denomination;
            atm.setThousandRupeeNotes(0);
        }
        if(Objects.nonNull(this.nextCashWithdrawalProcessor)){
            this.nextCashWithdrawalProcessor.processAmount(atm, remaining);
        }
    }
}
