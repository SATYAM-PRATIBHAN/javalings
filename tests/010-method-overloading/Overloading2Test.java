import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Overloading2Test {
    @Test
    public void testProcessInt() {
        assertEquals(50, Overloading2.process(5));
    }

    @Test
    public void testProcessString() {
        assertEquals("HELLO", Overloading2.process("hello"));
    }

    @Test
    public void testProcessArray() {
        assertEquals(15, Overloading2.process(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testProcessDouble() {
        assertEquals(5L, Overloading2.process(4.6));
        assertEquals(4L, Overloading2.process(4.4));
    }
}
