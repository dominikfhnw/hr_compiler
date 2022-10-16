import errors.LexicalError;
import org.junit.Test;
import scanner.Literal;
import scanner.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tests {

    @Test
    public void testScanner() {
        String file = "src/main/resources/grossmutter.txt";
        Path filePath = Path.of(file);
        System.out.println(filePath.toAbsolutePath());
        try {
            String content = Files.readString(filePath);
            Scanner.scan(content);
        } catch (IOException | LexicalError e) {
            e.printStackTrace();
        }
    }
}