import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Exceptions2Test {
    @Test
    public void testCustomException() throws Exception {
        // Use reflection to check if InsufficientFundsException exists and extends Exception
        Class<?> exceptionClass = Class.forName("Exceptions2$InsufficientFundsException");
        assertEquals(Exception.class, exceptionClass.getSuperclass());

        Exceptions2.BankAccount account = new Exceptions2.BankAccount(100.0);
        
        // Successful withdrawal
        assertEquals(60.0, account.withdraw(40.0), 0.001);

        // Failed withdrawal throwing custom exception
        Exception e = assertThrows(Exception.class, () -> {
            account.withdraw(100.0);
        });
        
        assertEquals(exceptionClass, e.getClass());
    }
}
