package Problems.Splitwise;

import Problems.Splitwise.User.User;

import java.util.List;

public class Expense {
    private int id;
    private String description;
    private List<Split> splitDetails;
    private double amount;
    private User paidBy;
    private SplitType splitType;

    private Expense(ExpenseBuilder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.splitDetails = builder.splitDetails;
        this.amount = builder.amount;
        this.paidBy = builder.paidBy;
        this.splitType = builder.splitType;
    }

    // Static method to get a new builder instance
    public static ExpenseBuilder builder() {
        return new ExpenseBuilder();
    }

    // Getters for all fields (optional but good practice)
    public int getId() { return id; }
    public String getDescription() { return description; }
    public List<Split> getListOfUsers() { return splitDetails; }
    public double getAmount() { return amount; }
    public User getPaidBy() { return paidBy; }
    public SplitType getSplitType() { return splitType; }


    // The static inner Builder class
    public static class ExpenseBuilder {
        private int id;
        private String description;
        private List<Split> splitDetails;
        private double amount;
        private User paidBy;
        private SplitType splitType;

        // Private constructor so it can only be accessed from the Expense class
        private ExpenseBuilder() {}

        public ExpenseBuilder id(int id) {
            this.id = id;
            return this; // Return the builder for chaining
        }

        public ExpenseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder splitDetails(List<Split> splitDetails) {
            this.splitDetails = splitDetails;
            return this;
        }

        public ExpenseBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseBuilder paidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public ExpenseBuilder splitType(SplitType splitType) {
            this.splitType = splitType;
            return this;
        }

        // The final build method that creates the Expense object
        public Expense build() {
            // Optional: Add validation logic before creating the object
            if (amount <= 0 || paidBy == null) {
                throw new IllegalArgumentException("Amount and PaidBy user cannot be empty.");
            }
            return new Expense(this);
        }
    }
}
