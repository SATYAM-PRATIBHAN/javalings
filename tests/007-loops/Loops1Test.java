import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Loops1Test {
    @Test
    public void testSumOfDigits() {
        assertEquals(15, Loops1.sumOfDigits(12345));
        assertEquals(9, Loops1.sumOfDigits(9000));
        assertEquals(7, Loops1.sumOfDigits(7));
    }

    @Test
    public void testCollatzLength() {
        // 12 -> 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 (9 steps)
        assertEquals(9, Loops1.collatzLength(12));
        assertEquals(0, Loops1.collatzLength(1)); // Already 1, 0 steps
    }
}
