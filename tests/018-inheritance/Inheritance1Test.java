import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Inheritance1Test {
    @Test
    public void testInheritance() {
        Inheritance1.Dog dog = new Inheritance1.Dog("Buddy");
        assertTrue(dog instanceof Inheritance1.Animal, "Dog must inherit from Animal");
        assertEquals("Buddy", dog.getName(), "Name should be inherited and set correctly");
        assertEquals("Woof!", dog.bark(), "bark() should return 'Woof!'");
    }
}
