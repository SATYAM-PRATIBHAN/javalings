import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Lambdas1Test {
    @Test
    public void testEvenPredicate() {
        assertTrue(Lambdas1.getEvenPredicate().test(4));
        assertFalse(Lambdas1.getEvenPredicate().test(5));
    }

    @Test
    public void testStringLengthFunction() {
        assertEquals(5, Lambdas1.getStringLengthFunction().apply("Hello"));
        assertEquals(0, Lambdas1.getStringLengthFunction().apply(""));
    }
}
