import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Strings3Test {
    @Test
    public void testGenerateReceipt() {
        assertEquals("Receipt #005 | Total: $45.50", Strings3.generateReceipt(5, 45.5));
        assertEquals("Receipt #012 | Total: $100.00", Strings3.generateReceipt(12, 100.0));
        assertEquals("Receipt #1024 | Total: $3.14", Strings3.generateReceipt(1024, 3.14159));
    }

    @Test
    public void testReverseText() {
        assertEquals("olleh", Strings3.reverseText("hello"));
        assertEquals("avaJ", Strings3.reverseText("Java"));
        assertEquals("", Strings3.reverseText(""));
    }
}
