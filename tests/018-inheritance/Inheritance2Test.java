import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Inheritance2Test {
    @Test
    public void testMethodOverriding() {
        Inheritance2.Manager manager = new Inheritance2.Manager();
        assertTrue(manager instanceof Inheritance2.Employee, "Manager must inherit from Employee");
        assertEquals(1500.0, manager.calculateBonus(), 0.001, "Manager bonus should be base bonus + 1000");
    }
}
