import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Conditionals1Test {
    @Test
    public void testIsLeapYear() {
        assertTrue(Conditionals1.isLeapYear(2020)); // Divisible by 4
        assertFalse(Conditionals1.isLeapYear(2021)); // Not divisible by 4
        assertFalse(Conditionals1.isLeapYear(1900)); // Divisible by 100 but not 400
        assertTrue(Conditionals1.isLeapYear(2000)); // Divisible by 400
    }

    @Test
    public void testCalculateShipping() {
        assertEquals(0, Conditionals1.calculateShipping(50.0, "Domestic"));
        assertEquals(5, Conditionals1.calculateShipping(49.99, "Domestic"));
        assertEquals(10, Conditionals1.calculateShipping(100.0, "International"));
        assertEquals(20, Conditionals1.calculateShipping(99.99, "International"));
        assertEquals(-1, Conditionals1.calculateShipping(50.0, "Mars"));
    }
}
