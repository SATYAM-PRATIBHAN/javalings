import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class Methods2Test {
    @Test
    public void testLevelUpScore() {
        int originalScore = 50;
        int newScore = Methods2.levelUpScore(originalScore);
        assertEquals(60, newScore);
    }

    @Test
    public void testDoubleLevelUpScore() {
        int originalScore = 50;
        int finalScore = Methods2.doubleLevelUpScore(originalScore);
        assertEquals(120, finalScore); // (50 + 10) * 2 = 120
    }
}
