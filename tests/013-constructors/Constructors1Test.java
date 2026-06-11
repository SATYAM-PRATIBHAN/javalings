import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Constructors1Test {
    @Test
    public void testConstructors() {
        Constructors1.UserProfile p1 = new Constructors1.UserProfile("Alice", 10);
        assertEquals("Alice", p1.username);
        assertEquals(10, p1.level);

        Constructors1.UserProfile p2 = new Constructors1.UserProfile("Bob");
        assertEquals("Bob", p2.username);
        assertEquals(1, p2.level);

        Constructors1.UserProfile p3 = new Constructors1.UserProfile();
        assertEquals("Guest", p3.username);
        assertEquals(1, p3.level);
    }
}
