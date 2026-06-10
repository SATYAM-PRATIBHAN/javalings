import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Overloading1Test {
    @Test
    public void testSquareArea() {
        assertEquals(25, Overloading1.calculateArea(5));
        assertEquals(100, Overloading1.calculateArea(10));
    }

    @Test
    public void testRectangleArea() {
        assertEquals(50, Overloading1.calculateArea(5, 10));
    }

    @Test
    public void testCircleArea() {
        assertEquals(Math.PI * 25, Overloading1.calculateArea(5.0), 0.001);
    }
}
