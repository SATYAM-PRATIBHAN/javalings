import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Operators1Test {
    @Test
    public void testCalculateTotalWithTax() {
        // Base: 100, Qty: 2 -> 200. Tax: 5% of 200 = 10. Total = 210.
        assertEquals(210, Operators1.calculateTotalWithTax(100, 2, 5));
        assertEquals(440, Operators1.calculateTotalWithTax(50, 8, 10));
    }

    @Test
    public void testItemsPurchasable() {
        assertEquals(3, Operators1.itemsPurchasable(100, 30));
        assertEquals(5, Operators1.itemsPurchasable(50, 10));
    }

    @Test
    public void testRemainingBudget() {
        assertEquals(10, Operators1.remainingBudget(100, 30));
        assertEquals(5, Operators1.remainingBudget(25, 10));
    }
}
