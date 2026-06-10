import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Arrays5Test {
    @Test
    public void testHaveSameElements() {
        int[] a1 = {3, 1, 2};
        int[] a2 = {1, 2, 3};
        assertTrue(Arrays5.haveSameElements(a1, a2));

        int[] a3 = {1, 2, 4};
        assertFalse(Arrays5.haveSameElements(a1, a3));
        
        int[] a4 = {1, 2, 3, 3};
        int[] a5 = {1, 2, 3};
        assertFalse(Arrays5.haveSameElements(a4, a5));
    }
}
