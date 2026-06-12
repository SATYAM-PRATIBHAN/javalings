import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;

public class Collections3Test {
    @Test
    public void testCreateInventory() {
        Map<String, Integer> map = Collections3.createInventory();
        assertEquals(2, map.size());
        assertEquals(50, map.get("Apples"));
        assertEquals(20, map.get("Bananas"));
    }

    @Test
    public void testUpdateInventory() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apples", 10);
        
        map = Collections3.updateInventory(map, "Apples", 5);
        assertEquals(15, map.get("Apples"));

        map = Collections3.updateInventory(map, "Oranges", 12);
        assertEquals(12, map.get("Oranges"));
    }
}
