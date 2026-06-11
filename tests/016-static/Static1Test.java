import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class Static1Test {
    @Test
    public void testStaticCounter() throws Exception {
        Field totalReqField = Static1.RequestCounter.class.getDeclaredField("totalRequests");
        assertTrue(Modifier.isStatic(totalReqField.getModifiers()), "totalRequests must be static");

        // Reset to 0 for test isolation
        totalReqField.setAccessible(true);
        totalReqField.set(null, 0);

        Static1.RequestCounter.addRequest();
        Static1.RequestCounter.addRequest();
        
        assertEquals(2, Static1.RequestCounter.getTotalRequests());
    }
}
