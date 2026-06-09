import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Variables3Test {
    @Test
    void testDivide() {
        assertEquals(2.5, Variables3.divide(5, 2), 0.001);
        assertEquals(3.0, Variables3.divide(9, 3), 0.001);
        assertEquals(0.5, Variables3.divide(1, 2), 0.001);
    }
}
