import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Polymorphism1Test {
    @Test
    public void testPolymorphism() {
        Polymorphism1.Animal myDog = new Polymorphism1.Dog();
        Polymorphism1.Animal myCat = new Polymorphism1.Cat();

        assertEquals("Bark", Polymorphism1.getAnimalSound(myDog));
        assertEquals("Meow", Polymorphism1.getAnimalSound(myCat));
    }
}
