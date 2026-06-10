import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Operators5Test {
    @Test
    public void testGetDiscountMessage() {
        assertEquals("Member Discount Applied", Operators5.getDiscountMessage(true));
        assertEquals("Sign up for our membership!", Operators5.getDiscountMessage(false));
    }

    @Test
    public void testCalculateFinalScore() {
        // (10 + 5) * 2 - 3 = 15 * 2 - 3 = 27
        assertEquals(27, Operators5.calculateFinalScore(10, 5, 3));
        
        // (0 + 10) * 2 - 5 = 20 - 5 = 15
        assertEquals(15, Operators5.calculateFinalScore(0, 10, 5));
    }
}
