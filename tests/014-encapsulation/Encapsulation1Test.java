import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class Encapsulation1Test {
    @Test
    public void testEncapsulation() throws Exception {
        Field field = Encapsulation1.Temperature.class.getDeclaredField("celsius");
        assertTrue(Modifier.isPrivate(field.getModifiers()), "celsius must be private");

        Encapsulation1.Temperature temp = new Encapsulation1.Temperature();
        temp.setCelsius(0);
        assertEquals(0.0, temp.getCelsius(), 0.001);
        assertEquals(32.0, temp.getFahrenheit(), 0.001);

        temp.setCelsius(100);
        assertEquals(100.0, temp.getCelsius(), 0.001);
        assertEquals(212.0, temp.getFahrenheit(), 0.001);

        temp.setCelsius(-300); // Invalid, should not change
        assertEquals(100.0, temp.getCelsius(), 0.001);
    }
}
