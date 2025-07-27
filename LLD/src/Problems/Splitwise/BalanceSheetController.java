package Problems.Splitwise;

import Problems.Splitwise.User.Balance;
import Problems.Splitwise.User.User;
import Problems.Splitwise.User.UserExpenseBalanceSheet;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateBalanceSheet(List<Split> splitDetails, User paidBy, double totalAmount) {
        UserExpenseBalanceSheet paidByUserBalanceSheet = paidBy.getUserExpenseBalanceSheet();
        paidByUserBalanceSheet.setTotalYouPaid(paidByUserBalanceSheet.getTotalYouPaid() + totalAmount);

        for (Split split : splitDetails) {

            User userOwe = split.getUser();
            double oweAmount = split.getAmount();
            UserExpenseBalanceSheet oweUserBalanceSheet = split.getUser().getUserExpenseBalanceSheet();

            // will cover paid by user as well
            oweUserBalanceSheet.setTotalExpense(oweUserBalanceSheet.getTotalExpense() + oweAmount);

            if (!split.getUser().equals(paidBy)) {
                paidByUserBalanceSheet.setTotalYouGetBack(paidByUserBalanceSheet.getTotalYouGetBack() + oweAmount);
                oweUserBalanceSheet.setTotalYouOwe(oweUserBalanceSheet.getTotalYouOwe() + oweAmount);
                //update the balance sheet between paid user and owe user
                Balance userOweBalance;
                if (paidByUserBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                    userOweBalance = paidByUserBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                } else {
                    userOweBalance = new Balance();
                    paidByUserBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);

                //update the balance sheet of owe user
                Balance userPaidBalance;
                if (oweUserBalanceSheet.getUserVsBalance().containsKey(paidBy.getUserId())) {
                    userPaidBalance = oweUserBalanceSheet.getUserVsBalance().get(paidBy.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    oweUserBalanceSheet.getUserVsBalance().put(paidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);

            }
        }
    }
        public void showBalanceSheetOfUser(User user){

            System.out.println("---------------------------------------");

            System.out.println("Balance sheet of user : " + user.getUserId());

            UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

            System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalExpense());
            System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
            System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
            System.out.println("TotalPaymentMade: " + userExpenseBalanceSheet.getTotalYouPaid());

            for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
                String userID = entry.getKey();
                Balance balance = entry.getValue();

                System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
            }

            System.out.println("---------------------------------------");
        }
    }

