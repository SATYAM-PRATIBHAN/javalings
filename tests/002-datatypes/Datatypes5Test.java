import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Datatypes5Test {
    @Test
    public void testGetTypeInference() {
        Object result = Datatypes5.getTypeInference();
        assertTrue(result instanceof String, "The result should be inferred as a String");
    }
}
