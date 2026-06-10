import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Loops2Test {
    @Test
    public void testCountBounces() {
        // Drop from 10, factor 0.5:
        // Bounce 1: height 5.0
        // Bounce 2: height 2.5
        // Bounce 3: height 1.25
        // Bounce 4: height 0.625 (< 1.0, stops)
        assertEquals(4, Loops2.countBounces(10.0, 0.5));
        
        // Drop from 0.5 (below 1.0). Must bounce at least once per instructions.
        assertEquals(1, Loops2.countBounces(0.5, 0.5));
    }

    @Test
    public void testFactorial() {
        assertEquals(24, Loops2.factorial(4));
        assertEquals(120, Loops2.factorial(5));
        assertEquals(1, Loops2.factorial(1));
    }
}
