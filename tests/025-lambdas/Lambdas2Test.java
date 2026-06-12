import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Lambdas2Test {
    @Test
    public void testMathOperations() {
        Lambdas2.MathOperation addOp = Lambdas2.getAdditionOperation();
        assertEquals(8, addOp.operate(5, 3));

        Lambdas2.MathOperation multOp = Lambdas2.getMultiplicationOperation();
        assertEquals(15, multOp.operate(5, 3));
    }
}
