package Problems.Splitwise;

import Problems.Splitwise.ConcreteSplitValidators.EqualSplitValidator;
import Problems.Splitwise.ConcreteSplitValidators.ExactSplitValidator;
import Problems.Splitwise.ConcreteSplitValidators.PercentageSplitValidator;

public class SplitValidatorFactory {
    public static SplitValidator getSplitValidator(SplitType splitType){
        switch (splitType){
            case EXACT :
                return new ExactSplitValidator();
            case PERCENTAGE:
                return new PercentageSplitValidator();
            case EQUAL:
                return new EqualSplitValidator();
            default:
                throw new IllegalArgumentException("SplitType not supported");
        }
    }
}
