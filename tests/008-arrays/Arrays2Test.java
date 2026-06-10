import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Arrays2Test {
    @Test
    public void testFindMax() {
        assertEquals(100, Arrays2.findMax(new int[]{10, -5, 100, 42}));
        assertEquals(Integer.MIN_VALUE, Arrays2.findMax(new int[]{}));
    }

    @Test
    public void testAverage() {
        assertEquals(3.0, Arrays2.average(new int[]{1, 2, 3, 4, 5}), 0.001);
        assertEquals(0.0, Arrays2.average(new int[]{}), 0.001);
    }
}
