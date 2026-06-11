import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class AccessModifiers1Test {
    @Test
    public void testModifiersAndMethod() throws Exception {
        Field passField = AccessModifiers1.SystemConfig.class.getDeclaredField("adminPassword");
        assertTrue(Modifier.isPrivate(passField.getModifiers()), "adminPassword must be private");

        Field timeoutField = AccessModifiers1.SystemConfig.class.getDeclaredField("connectionTimeout");
        assertTrue(Modifier.isProtected(timeoutField.getModifiers()), "connectionTimeout must be protected");

        AccessModifiers1.SystemConfig config = new AccessModifiers1.SystemConfig();
        assertFalse(config.updatePassword("wrong", "newPass"));
        assertTrue(config.updatePassword("defaultPassword", "newPass"));
        
        // Since it's private, we have to use reflection to verify it actually changed
        passField.setAccessible(true);
        assertEquals("newPass", passField.get(config));
    }
}
