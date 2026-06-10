import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Methods3Test {
    @Test
    public void testSumAll() {
        assertEquals(15, Methods3.sumAll(1, 2, 3, 4, 5));
        assertEquals(0, Methods3.sumAll());
        assertEquals(10, Methods3.sumAll(10));
    }

    @Test
    public void testPrintReport() {
        assertEquals("Report: Q1 Sales | Total: 150", Methods3.printReport("Q1 Sales", 50, 50, 50));
        assertEquals("Report: Empty | Total: 0", Methods3.printReport("Empty"));
    }
}
