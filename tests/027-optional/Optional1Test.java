import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class Optional1Test {
    @Test
    public void testFindValue() {
        Optional<String> opt1 = Optional1.findValue("Java");
        assertTrue(opt1.isPresent());
        assertEquals("Java", opt1.get());

        Optional<String> opt2 = Optional1.findValue(null);
        assertFalse(opt2.isPresent());
    }

    @Test
    public void testGetValueOrDefault() {
        assertEquals("Found", Optional1.getValueOrDefault(Optional.of("Found"), "Default"));
        assertEquals("Default", Optional1.getValueOrDefault(Optional.empty(), "Default"));
    }
}
