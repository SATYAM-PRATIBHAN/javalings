import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Conditionals2Test {
    @Test
    public void testGetDaysInMonth() {
        assertEquals(31, Conditionals2.getDaysInMonth(1, false)); // Jan
        assertEquals(28, Conditionals2.getDaysInMonth(2, false)); // Feb non-leap
        assertEquals(29, Conditionals2.getDaysInMonth(2, true));  // Feb leap
        assertEquals(30, Conditionals2.getDaysInMonth(4, false)); // Apr
        assertEquals(31, Conditionals2.getDaysInMonth(12, true)); // Dec
        assertEquals(-1, Conditionals2.getDaysInMonth(13, false)); // Invalid
    }

    @Test
    public void testGetTrafficLightAction() {
        assertEquals("Stop", Conditionals2.getTrafficLightAction("Red"));
        assertEquals("Slow Down", Conditionals2.getTrafficLightAction("Yellow"));
        assertEquals("Go", Conditionals2.getTrafficLightAction("Green"));
        assertEquals("Invalid Color", Conditionals2.getTrafficLightAction("Blue"));
    }
}
