package Problems.Practise.ATMPractise.CashWithdrawal;

import Problems.Practise.ATMPractise.CashWithdrawal.ConcreteCashWithdrawalProcessor.FiftyRupeeProcessor;
import Problems.Practise.ATMPractise.CashWithdrawal.ConcreteCashWithdrawalProcessor.HundredRupeeProcessor;
import Problems.Practise.ATMPractise.CashWithdrawal.ConcreteCashWithdrawalProcessor.ThousandRupeeProcessor;

public class CashWithdrawalProcessorChain {
    public static CashWithdrawalProcessor getCashWithdrawalProcessorChain(){
        ThousandRupeeProcessor thousandRupeeProcessor = new ThousandRupeeProcessor();
        HundredRupeeProcessor hundredRupeeProcessor = new HundredRupeeProcessor();
        FiftyRupeeProcessor fiftyRupeeProcessor = new FiftyRupeeProcessor();
        thousandRupeeProcessor.nextCashWithdrawalProcessor = hundredRupeeProcessor;
        hundredRupeeProcessor.nextCashWithdrawalProcessor = fiftyRupeeProcessor;
        return thousandRupeeProcessor;
    }
}
