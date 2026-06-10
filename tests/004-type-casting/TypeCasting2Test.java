import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TypeCasting2Test {
    @Test
    public void testProcessItem() {
        Weapon sword = new Weapon(50);
        Potion health = new Potion(20);
        Item unknown = new Item();

        assertEquals(50, TypeCasting2.processItem(sword));
        assertEquals(-20, TypeCasting2.processItem(health));
        assertEquals(0, TypeCasting2.processItem(unknown));
    }
}
