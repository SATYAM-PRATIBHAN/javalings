import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TypeCasting3Test {
    @Test
    public void testAddAndBox() {
        assertEquals(Long.valueOf(10L), TypeCasting3.addAndBox(Integer.valueOf(5), Integer.valueOf(5)));
        
        // Test overflow prevention!
        Integer max = Integer.MAX_VALUE;
        Long expected = (long) max + max;
        assertEquals(expected, TypeCasting3.addAndBox(max, max));
    }

    @Test
    public void testDowncastId() {
        assertEquals(100, TypeCasting3.downcastId(100L));
        
        // When casting a long that is larger than Integer.MAX_VALUE down to an int, 
        // it overflows and becomes a completely different (often negative) number!
        long tooBig = (long) Integer.MAX_VALUE + 5L;
        int expectedOverflow = (int) tooBig;
        assertEquals(expectedOverflow, TypeCasting3.downcastId(tooBig));
    }
}
