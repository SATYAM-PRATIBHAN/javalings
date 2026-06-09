import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Datatypes6Test {
    @Test
    public void testGetScore() {
        int result = Datatypes6.getScore();
        assertTrue(result >= 0 || result < 0, "Should successfully unbox without throwing NullPointerException");
    }
}
