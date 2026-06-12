import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Exceptions1Test {
    @Test
    public void testParseIntOrDefault() {
        assertEquals(42, Exceptions1.parseIntOrDefault("42", 0));
        assertEquals(-1, Exceptions1.parseIntOrDefault("abc", -1));
        assertEquals(100, Exceptions1.parseIntOrDefault("100", 50));
        assertEquals(50, Exceptions1.parseIntOrDefault("", 50));
    }
}
