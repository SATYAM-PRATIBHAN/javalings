import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Methods1Test {
    @Test
    public void testCalculateDiscount() {
        assertEquals(80.0, Methods1.calculateDiscount(100.0, 20.0), 0.001);
        assertEquals(45.0, Methods1.calculateDiscount(50.0, 10.0), 0.001);
    }

    @Test
    public void testIsEven() {
        assertTrue(Methods1.isEven(4));
        assertFalse(Methods1.isEven(7));
        assertTrue(Methods1.isEven(0));
    }
}
