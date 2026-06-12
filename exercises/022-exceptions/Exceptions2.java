// I AM NOT DONE

public class Exceptions2 {

    // 1. Create a STATIC custom exception class named 'InsufficientFundsException'.
    // It must extend the standard Java 'Exception' class.
    // It should have a constructor that takes a String message and passes it to super(message).
    // YOUR CODE HERE
    

    static class BankAccount {
        double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        // 2. Complete the 'withdraw' method.
        // It must declare that it 'throws InsufficientFundsException'.
        // Inside the method, if 'amount' > 'balance', throw a new InsufficientFundsException.
        // Otherwise, subtract 'amount' from 'balance' and return the new balance.
        public double withdraw(double amount) {
            // YOUR CODE HERE
            return 0.0;
        }
    }
}
