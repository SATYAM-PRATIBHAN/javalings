import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Operators4Test {
    private static final int READ = 4;
    private static final int WRITE = 2;
    private static final int EXEC = 1;

    @Test
    public void testGrantPermission() {
        assertEquals(6, Operators4.grantPermission(READ, WRITE)); // 4 | 2 = 6
        assertEquals(7, Operators4.grantPermission(6, EXEC));     // 6 | 1 = 7
        assertEquals(4, Operators4.grantPermission(4, READ));     // 4 | 4 = 4
    }

    @Test
    public void testHasPermission() {
        assertTrue(Operators4.hasPermission(6, READ));   // 6 has READ (4)
        assertTrue(Operators4.hasPermission(6, WRITE));  // 6 has WRITE (2)
        assertFalse(Operators4.hasPermission(6, EXEC));  // 6 does NOT have EXEC (1)
        assertTrue(Operators4.hasPermission(7, EXEC));
    }

    @Test
    public void testRevokePermission() {
        assertEquals(4, Operators4.revokePermission(6, WRITE)); // 6 without 2 is 4
        assertEquals(6, Operators4.revokePermission(7, EXEC));  // 7 without 1 is 6
        assertEquals(4, Operators4.revokePermission(4, WRITE)); // 4 without 2 is still 4
    }
}
