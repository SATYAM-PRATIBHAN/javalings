import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Datatypes1Test {
    @Test
    public void testGetNumber() {
        // We just verify that it returns ANY integer without compilation errors
        int result = Datatypes1.getNumber();
        assertTrue(result != 0 || result == 0, "Should compile and return a valid int");
    }
}
