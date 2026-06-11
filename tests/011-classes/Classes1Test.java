import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Classes1Test {
    @Test
    public void testConstructor() {
        Classes1.BankAccount account1 = new Classes1.BankAccount("ACC123", 100.0);
        assertEquals("ACC123", account1.accountNumber);
        assertEquals(100.0, account1.balance, 0.001);
        assertTrue(account1.isActive);

        Classes1.BankAccount account2 = new Classes1.BankAccount("ACC456", 0.0);
        assertFalse(account2.isActive);
    }

    @Test
    public void testDeposit() {
        Classes1.BankAccount account = new Classes1.BankAccount("ACC123", 0.0);
        assertFalse(account.isActive);

        assertFalse(account.deposit(-50.0));
        assertEquals(0.0, account.balance, 0.001);

        assertTrue(account.deposit(50.0));
        assertEquals(50.0, account.balance, 0.001);
        assertTrue(account.isActive);
    }

    @Test
    public void testWithdraw() {
        Classes1.BankAccount account = new Classes1.BankAccount("ACC123", 100.0);
        assertTrue(account.isActive);

        assertFalse(account.withdraw(150.0)); // Not enough money
        assertEquals(100.0, account.balance, 0.001);

        assertTrue(account.withdraw(40.0));
        assertEquals(60.0, account.balance, 0.001);

        assertFalse(account.withdraw(-10.0)); // Negative amount
        
        account.isActive = false;
        assertFalse(account.withdraw(10.0)); // Inactive account
    }
}
