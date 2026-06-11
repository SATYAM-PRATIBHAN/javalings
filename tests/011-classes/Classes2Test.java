import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Classes2Test {
    @BeforeEach
    public void resetStatic() {
        Classes2.Library.totalBooksInSystem = 0;
    }

    @Test
    public void testAddBooks() {
        Classes2.Library libA = new Classes2.Library("Downtown");
        Classes2.Library libB = new Classes2.Library("Uptown");

        libA.addBooks(100);
        assertEquals(100, libA.bookCount);
        assertEquals(0, libB.bookCount);
        assertEquals(100, Classes2.Library.getTotalBooksInSystem());

        libB.addBooks(50);
        assertEquals(50, libB.bookCount);
        assertEquals(150, Classes2.Library.getTotalBooksInSystem());
    }

    @Test
    public void testTransferBooks() {
        Classes2.Library libA = new Classes2.Library("Downtown");
        Classes2.Library libB = new Classes2.Library("Uptown");

        libA.addBooks(100);
        libB.addBooks(50);
        assertEquals(150, Classes2.Library.getTotalBooksInSystem());

        assertTrue(libA.transferBooks(libB, 30));
        assertEquals(70, libA.bookCount);
        assertEquals(80, libB.bookCount);
        
        // Transfer should not change total system books
        assertEquals(150, Classes2.Library.getTotalBooksInSystem());

        assertFalse(libB.transferBooks(libA, 100)); // Not enough books
    }
}
