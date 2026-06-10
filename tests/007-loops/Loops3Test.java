import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Loops3Test {
    @Test
    public void testBuildTriangle() {
        String expected3 = "*\n**\n***\n";
        assertEquals(expected3, Loops3.buildTriangle(3));
        
        String expected5 = "*\n**\n***\n****\n*****\n";
        assertEquals(expected5, Loops3.buildTriangle(5));
    }

    @Test
    public void testSumEvenNumbers() {
        // Evens between 1 and 10: 2 + 4 + 6 + 8 + 10 = 30
        assertEquals(30, Loops3.sumEvenNumbers(1, 10));
        
        // Evens between 3 and 7: 4 + 6 = 10
        assertEquals(10, Loops3.sumEvenNumbers(3, 7));
    }
}
