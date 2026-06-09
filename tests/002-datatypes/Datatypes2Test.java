import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Datatypes2Test {
    @Test
    public void testGetBigNumber() {
        assertEquals(4000000000L, Datatypes2.getBigNumber(), "The big number should be 4000000000");
    }
}
