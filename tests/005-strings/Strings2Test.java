import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Strings2Test {
    @Test
    public void testExtractLogLevel() {
        assertEquals("ERROR", Strings2.extractLogLevel("ERROR: Database connection failed"));
        assertEquals("INFO", Strings2.extractLogLevel("INFO: Server started on port 8080"));
    }

    @Test
    public void testExtractUserId() {
        assertEquals(405, Strings2.extractUserId("User logged in [405]"));
        assertEquals(99, Strings2.extractUserId("Failed login attempt [99]"));
    }
}
