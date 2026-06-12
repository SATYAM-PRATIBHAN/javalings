import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Generics2Test {
    @Test
    public void testGetMax() {
        assertEquals(10, Generics2.getMax(5, 10));
        assertEquals(20, Generics2.getMax(20, 15));
        
        assertEquals("Zebra", Generics2.getMax("Apple", "Zebra"));
        
        assertEquals(3.14, Generics2.getMax(3.14, 2.71));
    }
}
