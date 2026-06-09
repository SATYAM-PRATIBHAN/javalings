import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Variables1Test {
    @Test
    void shouldReturn25() {
        assertEquals(
            25,
            Variables1.getAge()
        );
    }
}
