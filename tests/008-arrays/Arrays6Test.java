import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Arrays6Test {
    @Test
    public void testReverseInPlace() {
        int[] evens = {1, 2, 3, 4};
        Arrays6.reverseInPlace(evens);
        assertArrayEquals(new int[]{4, 3, 2, 1}, evens);

        int[] odds = {1, 2, 3, 4, 5};
        Arrays6.reverseInPlace(odds);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, odds);
    }

    @Test
    public void testShiftRight() {
        int[] arr = {10, 20, 30, 40};
        Arrays6.shiftRight(arr);
        assertArrayEquals(new int[]{40, 10, 20, 30}, arr);
        
        Arrays6.shiftRight(arr);
        assertArrayEquals(new int[]{30, 40, 10, 20}, arr);
    }
}
