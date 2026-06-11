import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class Objects1Test {
    @Test
    public void testCreateAndDrive() {
        Objects1.Car car = Objects1.createAndDrive();
        assertNotNull(car, "Method must return a Car object");
        assertTrue(car.engineRunning, "Engine should be running");
        assertEquals(50, car.mileage, "Car should be driven for 50 miles");
    }
}
