import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Variables2Test {
    @Test
    void testMultiply() {
        assertEquals(10, Variables2.multiplyByTwo(5));
        assertEquals(0, Variables2.multiplyByTwo(0));
        assertEquals(-6, Variables2.multiplyByTwo(-3));
    }
}
