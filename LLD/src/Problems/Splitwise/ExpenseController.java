package Problems.Splitwise;

import Problems.Splitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }
    public void createExpense(int expenseId, String description, double amount, User paidBy, SplitType splitType, List<Split> splitDetails) {
        SplitValidator splitValidator = SplitValidatorFactory.getSplitValidator(splitType);
        if (!splitValidator.isValidSplit(splitDetails, amount)) {
            // throw some exception
        }
        Expense expense = Expense.builder().id(expenseId).amount(amount).splitDetails(splitDetails)
                .splitType(splitType).description(description).paidBy(paidBy).build();
        balanceSheetController.updateBalanceSheet(splitDetails, paidBy, amount);

    }
}
