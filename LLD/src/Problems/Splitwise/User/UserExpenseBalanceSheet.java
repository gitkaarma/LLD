package Problems.Splitwise.User;

import java.util.Map;

public class UserExpenseBalanceSheet {
    private double totalYouOwe;
    private double totalYouGetBack;
    private double totalExpense;
    private double totalYouPaid;
    private Map<String, Balance> userVsBalance; // for the user to whom this Balance Sheet belongs to, who owes how much

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalYouPaid() {
        return totalYouPaid;
    }

    public void setTotalYouPaid(double totalYouPaid) {
        this.totalYouPaid = totalYouPaid;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }
}
