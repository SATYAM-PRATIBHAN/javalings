import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Arrays1Test {
    @Test
    public void testGetFirstAndLast() {
        assertArrayEquals(new int[]{10, 50}, Arrays1.getFirstAndLast(new int[]{10, 20, 30, 40, 50}));
        assertArrayEquals(new int[]{5, 5}, Arrays1.getFirstAndLast(new int[]{5}));
    }

    @Test
    public void testDoubleScores() {
        int[] scores = {1, 2, 3};
        Arrays1.doubleScores(scores);
        assertArrayEquals(new int[]{2, 4, 6}, scores);
    }
}
