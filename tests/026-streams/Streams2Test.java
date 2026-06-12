import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

public class Streams2Test {
    @Test
    public void testSumOfLengths() {
        List<String> words = List.of("apple", "banana", "cherry");
        assertEquals(17, Streams2.sumOfLengths(words));
    }

    @Test
    public void testGroupStringsByLength() {
        List<String> words = List.of("a", "bb", "c", "dd", "eee");
        Map<Integer, List<String>> result = Streams2.groupStringsByLength(words);
        
        assertEquals(List.of("a", "c"), result.get(1));
        assertEquals(List.of("bb", "dd"), result.get(2));
        assertEquals(List.of("eee"), result.get(3));
    }
}
