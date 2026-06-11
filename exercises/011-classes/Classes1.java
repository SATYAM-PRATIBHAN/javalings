// I AM NOT DONE

public class Classes1 {
    // You are building a BankAccount class.
    // The class structure is provided, but the logic is missing!

    static class BankAccount {
        String accountNumber;
        double balance;
        boolean isActive;

        // 1. Write the constructor.
        // It should take a String 'accountNumber' and double 'initialBalance'.
        // If 'initialBalance' is greater than 0, 'isActive' should be true.
        // Otherwise, 'isActive' should be false.
        public BankAccount(String accountNumber, double initialBalance) {
            // YOUR CODE HERE
        }

        // 2. Write the 'deposit' method.
        // It takes a double 'amount'.
        // If amount is greater than 0:
        //   - Add it to the balance.
        //   - Set isActive to true (since the account now has money).
        //   - Return true (successful deposit).
        // Otherwise, return false.
        public boolean deposit(double amount) {
            // YOUR CODE HERE
            return false;
        }

        // 3. Write the 'withdraw' method.
        // It takes a double 'amount'.
        // You can only withdraw if:
        //   - The account isActive.
        //   - The amount is greater than 0.
        //   - The balance is greater than or equal to the amount.
        // If all conditions are met, subtract the amount and return true.
        // Otherwise, return false.
        public boolean withdraw(double amount) {
            // YOUR CODE HERE
            return false;
        }
    }
}
