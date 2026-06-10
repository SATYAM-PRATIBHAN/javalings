import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Operators3Test {
    @Test
    public void testLevelUp() {
        assertEquals(6, Operators3.levelUp(5));
        assertEquals(100, Operators3.levelUp(99));
    }

    @Test
    public void testTakeDamage() {
        assertEquals(80, Operators3.takeDamage(100, 20));
        assertEquals(5, Operators3.takeDamage(50, 45));
    }

    @Test
    public void testApplyMultiplier() {
        assertEquals(100, Operators3.applyMultiplier(50, 2));
        assertEquals(0, Operators3.applyMultiplier(0, 10));
    }
}
