import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
            scan(content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LexicalError e) {
            e.printStackTrace();
        }
    }
    public static class LexicalError extends Exception {
        public LexicalError(String errorMessage) {
            super(errorMessage);
        }
    }
    public static void debug(String msg){
        System.out.println(msg);
    }

    public static boolean isSpecial(char c){
        return
                Arrays.asList('(', ',', ')', ':', ';', '=', '/', '\\', '/', '<', '>', '+', '-', '*', '~', '!', '?').
                        contains(c);
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
            //debug("char "+c);
            switch (state) {
                case 0:
                    if (Character.isDigit(c)) {
                        state = 2;
                        int digit = Character.digit(c, 10);
                        numAccu = digit;
                        //debug("0->2 digit "+numAccu);
                    } else if (Character.isAlphabetic(c)) {
                        state = 1;
                        lexAccu = new StringBuffer(1024);
                        lexAccu.append(c);

                        //debug("0->1 alpha "+lexAccu);
                    } else if (Character.isWhitespace(c)) {
                        // ignore
                    } else if (isSpecial(c)) {
                        state = 3;
                        lexAccu = new StringBuffer(1024);
                        lexAccu.append(c);
                    } else {
                        throw new LexicalError("illegal char: "+c);
                    }
                    break;
                case 1:
                    if (Character.isLetterOrDigit(c)){
                        state = 1;
                        //debug("1 digit "+lexAccu);
                        lexAccu.append(c);
                    } else {
                        state = 0;
                        i = i - 1;
                        debug("IDENT "+lexAccu);
                    }
                    break;
                case 2:
                    if (Character.isDigit(c)) {
                        state = 2;
                        int digit = Character.digit(c, 10);
                        numAccu = numAccu * 10 + digit;
                        //debug("2 digit "+numAccu);
                        if (numAccu > Integer.MAX_VALUE) {
                            throw new LexicalError("Integer literal too large!");
                        }
                    } else {
                        state = 0;
                        i = i - 1; // one back for next lexeme
                        debug("LITERAL "+numAccu);
                        // l.add(new IToken.Literal(new Value.IntVal((int) numAccu)));
                    }
                    break;
                case 3:
                    if (isSpecial(c)){
                        state = 3;
                        lexAccu.append(c);
                    } else {
                        state = 0;
                        i = i - 1;
                        debug("OP "+lexAccu);
                    }
                    break;
                default:
                    throw new LexicalError("strange case entered: "+state);
            }
        }

        assert state == 0;
        //l.add(new IToken.Base(Terminals.SENTINEL));
        //return l;

    }
}