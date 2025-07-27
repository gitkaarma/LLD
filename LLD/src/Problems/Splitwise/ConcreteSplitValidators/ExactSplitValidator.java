package Problems.Splitwise.ConcreteSplitValidators;

import Problems.Splitwise.Split;
import Problems.Splitwise.SplitValidator;

import java.util.List;

public class ExactSplitValidator implements SplitValidator {

    @Override
    public boolean isValidSplit(List<Split> splitList, double amount) {
        double totalAmount = 0;
        for(Split split: splitList){
            totalAmount += split.getAmount();
        }
        return totalAmount == amount;
    }
}
