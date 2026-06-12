import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.io.IOException;

public class FileHandling1Test {
    @TempDir
    Path tempDir;

    @Test
    public void testFileReadWrite() throws IOException {
        Path file = tempDir.resolve("test.txt");
        String content = "Hello, File Handling!";
        
        FileHandling1.writeToFile(file, content);
        String readContent = FileHandling1.readFromFile(file);
        
        assertEquals(content, readContent);
    }
}
