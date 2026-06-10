import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Strings1Test {
    @Test
    public void testComparePasswords() {
        String pass1 = new String("mySecret123");
        String pass2 = new String("mySecret123");
        String pass3 = new String("wrongPass");
        
        assertTrue(Strings1.comparePasswords(pass1, pass2));
        assertFalse(Strings1.comparePasswords(pass1, pass3));
    }

    @Test
    public void testStandardizeUsername() {
        assertEquals("cooluser99", Strings1.standardizeUsername("  coolUSER99  "));
        assertEquals("admin", Strings1.standardizeUsername("ADMIN"));
    }
}
