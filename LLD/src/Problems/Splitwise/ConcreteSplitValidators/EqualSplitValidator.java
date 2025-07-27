package Problems.Splitwise.ConcreteSplitValidators;

import Problems.Splitwise.Split;
import Problems.Splitwise.SplitValidator;

import java.util.List;

public class EqualSplitValidator implements SplitValidator {

    @Override
    public boolean isValidSplit(List<Split> splitList, double amount) {
        double individualSplitAmount = amount/(splitList.size());
        for(Split split: splitList){
            if(split.getAmount() != individualSplitAmount){
                return false;
            }
        }
        return true;
    }
}
