import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Streams1Test {
    @Test
    public void testGetEvenSquares() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        List<Integer> result = Streams1.getEvenSquares(input);
        assertEquals(List.of(4, 16), result);
    }
}
