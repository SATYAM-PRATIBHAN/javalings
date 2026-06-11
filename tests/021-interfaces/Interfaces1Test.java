import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Interfaces1Test {
    @Test
    public void testInterfaces() {
        Interfaces1.Playable guitar = new Interfaces1.Guitar();
        assertEquals("Strum", guitar.play());

        Interfaces1.Playable piano = new Interfaces1.Piano();
        assertEquals("Plink", piano.play());
    }
}
