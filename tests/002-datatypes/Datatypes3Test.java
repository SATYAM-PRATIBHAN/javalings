import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Datatypes3Test {
    @Test
    public void testDivide() {
        assertEquals(2.5, Datatypes3.divide(), 0.001, "The result should be exactly 2.5");
    }
}
