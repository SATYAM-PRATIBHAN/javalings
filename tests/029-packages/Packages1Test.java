import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

public class Packages1Test {
    @Test
    public void testScannerImport() {
        assertDoesNotThrow(() -> {
            Packages1.readInput();
        });
    }
}
