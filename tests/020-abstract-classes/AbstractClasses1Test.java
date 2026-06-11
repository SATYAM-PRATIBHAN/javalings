import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

public class AbstractClasses1Test {
    @Test
    public void testAbstractClass() throws Exception {
        assertTrue(Modifier.isAbstract(AbstractClasses1.Shape.class.getModifiers()), "Shape must be abstract");
        
        AbstractClasses1.Shape square = new AbstractClasses1.Square(5);
        assertEquals(25.0, square.getArea(), 0.001);

        AbstractClasses1.Shape circle = new AbstractClasses1.Circle(3);
        assertEquals(Math.PI * 9, circle.getArea(), 0.001);
    }
}
