import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Interfaces2Test {
    @Test
    public void testMultipleInterfaces() {
        Interfaces2.ElectricCar car = new Interfaces2.ElectricCar();
        
        Interfaces2.Movable movable = car;
        assertEquals("Zoom!", movable.move());

        Interfaces2.Chargeable chargeable = car;
        assertEquals(100, chargeable.getChargeLevel());
        assertEquals("Lithium-Ion", chargeable.getBatteryType());
    }
}
