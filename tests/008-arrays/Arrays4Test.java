import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Arrays4Test {
    @Test
    public void testAppendElement() {
        int[] original = {1, 2, 3};
        int[] result = Arrays4.appendElement(original, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
        assertArrayEquals(new int[]{1, 2, 3}, original); // Ensure original isn't modified somehow
    }

    @Test
    public void testRemoveElementAt() {
        int[] original = {10, 20, 30, 40};
        int[] result = Arrays4.removeElementAt(original, 1);
        assertArrayEquals(new int[]{10, 30, 40}, result);
    }
}
