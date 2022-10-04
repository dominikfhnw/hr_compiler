import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Path filePath = Path.of("test.txt");
        System.out.println(filePath.toAbsolutePath());
        String content;
        try {
            content = Files.readString(filePath);
            scan(content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LexicalError e) {
            e.printStackTrace();
        }
    }
    public class LexicalError extends Exception {
        public LexicalError(String errorMessage) {
            super(errorMessage);
        }
    }
    public static void scan(CharSequence cs) throws LexicalError {
        // precondition: last character (if it exists) is a newline
        assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
        //ITokenList l= new TokenList();
        int state = 0;
        StringBuffer lexAccu = null; // for constructing the identifier
        long numAccu = 0L; // for constructing the literal value
        for (int i = 0; i < cs.length(); i++) {
            char c = cs.charAt(i);
            switch (state) {
                case 0:
                    if (Character.isDigit(c)) {
                        state = 2;
                        int digit = Character.digit(c, 10);
                        numAccu = digit;
                    }
                case 2:
                    if (Character.isDigit(c)) {
                        state = 2;
                        int digit = Character.digit(c, 10);
                        numAccu = numAccu * 10 + digit;
                        System.out.print("DIGITS "); System.out.println(numAccu);

                        if (numAccu > Integer.MAX_VALUE) {
                            //throw new LexicalError("Integer literal too large!");
                        }
                    } else {
                        state = 0;
                        i = i - 1; // one back for next lexeme
                        // l.add(new IToken.Literal(new Value.IntVal((int) numAccu)));
                    }
                    break;
            }
        }

        assert state == 0;
        //l.add(new IToken.Base(Terminals.SENTINEL));
        //return l;

    }
}
