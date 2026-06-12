import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class FileHandling2Test {
    @TempDir
    Path tempDir;

    @Test
    public void testCountLines() throws IOException {
        Path file = tempDir.resolve("lines.txt");
        Files.writeString(file, "Line 1\nLine 2\nLine 3");
        
        long count = FileHandling2.countLines(file);
        assertEquals(3, count);
    }

    @Test
    public void testCopyFile() throws IOException {
        Path source = tempDir.resolve("source.txt");
        Path target = tempDir.resolve("target.txt");
        Files.writeString(source, "Copy me");
        
        FileHandling2.copyFile(source, target);
        
        assertTrue(Files.exists(target));
        assertEquals("Copy me", Files.readString(target));
    }
}
