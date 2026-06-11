import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class Final1Test {
    @Test
    public void testFinalModifiers() throws Exception {
        assertTrue(Modifier.isFinal(Final1.class.getModifiers()), "Final1 class must be final");

        Field maxRetries = Final1.SecureAlgorithm.class.getDeclaredField("MAX_RETRIES");
        assertTrue(Modifier.isPublic(maxRetries.getModifiers()), "MAX_RETRIES must be public");
        assertTrue(Modifier.isStatic(maxRetries.getModifiers()), "MAX_RETRIES must be static");
        assertTrue(Modifier.isFinal(maxRetries.getModifiers()), "MAX_RETRIES must be final");
        assertEquals(5, maxRetries.get(null));

        Method execMethod = Final1.SecureAlgorithm.class.getDeclaredMethod("execute");
        assertTrue(Modifier.isFinal(execMethod.getModifiers()), "execute method must be final");
    }
}
