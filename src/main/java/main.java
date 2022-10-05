import errors.LexicalError;
import scanner.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {
        String file = "test.txt";
        if(args.length > 0){
            file = args[0];
        }
        Path filePath = Path.of(file);
        System.out.println(filePath.toAbsolutePath());
        String content;
        try {
            content = Files.readString(filePath);
            Scanner.scan(content);
        } catch (IOException | LexicalError e) {
            e.printStackTrace();
        }
    }
}