import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class Collections1Test {
    @Test
    public void testCreateList() {
        List<String> list = Collections1.createAndPopulateList();
        assertEquals(3, list.size());
        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Cherry", list.get(2));
    }

    @Test
    public void testRemoveElement() {
        List<String> input = new ArrayList<>(List.of("A", "B", "C"));
        List<String> result = Collections1.removeSecondElement(input);
        assertEquals(2, result.size());
        assertEquals("A", result.get(0));
        assertEquals("C", result.get(1));
    }
}
