import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Enums1Test {
    @Test
    public void testTrafficLight() {
        assertEquals(Enums1.TrafficLight.GREEN, Enums1.getNextLight(Enums1.TrafficLight.RED));
        assertEquals(Enums1.TrafficLight.YELLOW, Enums1.getNextLight(Enums1.TrafficLight.GREEN));
        assertEquals(Enums1.TrafficLight.RED, Enums1.getNextLight(Enums1.TrafficLight.YELLOW));
    }
}
