import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Generics1Test {
    @Test
    public void testGenericBox() {
        Generics1.Box<String> stringBox = new Generics1.Box<>("Hello");
        assertEquals("Hello", stringBox.getItem());
        stringBox.setItem("World");
        assertEquals("World", stringBox.getItem());

        Generics1.Box<Integer> intBox = new Generics1.Box<>(42);
        assertEquals(42, intBox.getItem());
    }
}
