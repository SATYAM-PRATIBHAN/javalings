import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TypeCasting1Test {
    @Test
    public void testDisplayTemperature() {
        assertEquals(98, TypeCasting1.displayTemperature(98.6));
        assertEquals(-5, TypeCasting1.displayTemperature(-5.99));
    }

    @Test
    public void testCalculateExactSpeed() {
        assertEquals(2.5, TypeCasting1.calculateExactSpeed(5, 2));
        assertEquals(3.333, TypeCasting1.calculateExactSpeed(10, 3), 0.001);
    }

    @Test
    public void testGetAsciiValue() {
        assertEquals(65, TypeCasting1.getAsciiValue('A'));
        assertEquals(97, TypeCasting1.getAsciiValue('a'));
    }
}
