import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Operators2Test {
    @Test
    public void testIsEligibleForRegistration() {
        assertTrue(Operators2.isEligibleForRegistration(18, false));
        assertTrue(Operators2.isEligibleForRegistration(25, false));
        assertTrue(Operators2.isEligibleForRegistration(16, true));
        assertFalse(Operators2.isEligibleForRegistration(16, false));
    }

    @Test
    public void testIsValidPin() {
        assertTrue(Operators2.isValidPin(1000));
        assertTrue(Operators2.isValidPin(9999));
        assertTrue(Operators2.isValidPin(5555));
        assertFalse(Operators2.isValidPin(999));
        assertFalse(Operators2.isValidPin(10000));
    }

    @Test
    public void testCanAccessSecretArea() {
        assertTrue(Operators2.canAccessSecretArea(21, true, 9999));
        assertTrue(Operators2.canAccessSecretArea(30, true, 9999));
        assertFalse(Operators2.canAccessSecretArea(20, true, 9999)); // too young
        assertFalse(Operators2.canAccessSecretArea(25, false, 9999)); // not VIP
        assertFalse(Operators2.canAccessSecretArea(25, true, 1234)); // wrong PIN
    }
}
