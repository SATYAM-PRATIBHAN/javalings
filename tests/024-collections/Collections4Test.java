import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class Collections4Test {
    @Test
    public void testSortAscending() {
        List<Integer> list = new ArrayList<>(List.of(5, 1, 4, 2, 3));
        List<Integer> result = Collections4.sortAscending(list);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    public void testReverseList() {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));
        List<String> result = Collections4.reverseList(list);
        assertEquals(List.of("C", "B", "A"), result);
    }
}
