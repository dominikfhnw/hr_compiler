import errors.LexicalError;
import org.junit.Test;
import scanner.ITokenList;
import scanner.Scanner;
import scanner.enums.Operators;
import scanner.enums.Terminals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testScanner() {
        String file = "src/main/resources/Add17.iml";
        Path filePath = Path.of(file);
        System.out.println(filePath.toAbsolutePath());
        try {
            String content = Files.readString(filePath);
            ITokenList i;
            i = Scanner.scan(content);
            System.out.println("SCANNER FINISHED");
            System.out.println(i);
        } catch (IOException | LexicalError e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsLexeme() {
        assertTrue(Operators.MOD_T.isLexeme());
        assertFalse(Operators.COR.isLexeme());
        assertTrue(Terminals.LITERAL.isLexeme());
        assertFalse(Terminals.EXCL.isLexeme());
    }

    @Test
    public void testIsSymbol() {
        assertFalse(Operators.MOD_T.isSymbol());
        assertTrue(Operators.MINUS.isSymbol());
        assertFalse(Terminals.LITERAL.isSymbol());
        assertTrue(Terminals.EXCL.isSymbol());
    }

    @Test
    public void testGetSymbol() {
        assertEquals('+', Operators.PLUS.getSymbol());
        assertEquals('?', Terminals.QUEST.getSymbol());
    }

    @Test
    public void testGetLexeme() {
        assertEquals("divT", Operators.DIV_T.getLexeme());
        assertEquals("literal", Terminals.LITERAL.getLexeme());
    }
}