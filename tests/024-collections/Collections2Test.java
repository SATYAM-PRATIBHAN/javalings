import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

public class Collections2Test {
    @Test
    public void testRemoveDuplicates() {
        List<Integer> input = List.of(1, 2, 2, 3, 3, 3, 4);
        Set<Integer> result = Collections2.removeDuplicates(input);
        assertEquals(4, result.size());
        assertTrue(result.containsAll(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testContainsElement() {
        Set<String> set = Set.of("Hello", "World");
        assertTrue(Collections2.containsElement(set, "Hello"));
        assertFalse(Collections2.containsElement(set, "Java"));
    }
}
