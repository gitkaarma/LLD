package Problems.ATM.AmountWithdrawal;

import Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors.HundredRupeeProcessor;
import Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors.ThousandRupeeProcessor;
import Problems.ATM.AmountWithdrawal.ConcreteCashWithdrawalProcessors.TwoHundredRupeeProcessor;

public class CashWithdrawalProcessorChain {
    public static CashWithdrawalProcessor getCashWithdrawalProcessor(){
        CashWithdrawalProcessor hundredRupeeProcessor = new HundredRupeeProcessor();
        CashWithdrawalProcessor twoHundredRupeeProcessor = new TwoHundredRupeeProcessor();
        CashWithdrawalProcessor thousandRupeeProcessor = new ThousandRupeeProcessor();
        thousandRupeeProcessor.setNextCashWithdrawalProcessor(twoHundredRupeeProcessor);
        twoHundredRupeeProcessor.setNextCashWithdrawalProcessor(hundredRupeeProcessor);
        return thousandRupeeProcessor;
    }
}
