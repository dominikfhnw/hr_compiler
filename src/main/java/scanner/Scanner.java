package scanner;

import errors.LexicalError;
import scanner.enums.Terminals;
import java.util.Arrays;
public class Scanner {

    public static void debug(String msg){
        System.out.println(msg);
    }

    public static boolean isSpecial(char c){
        return Arrays.asList('(', ',', ')', ':', ';', '=', '/', '\\', '/', '<', '>', '+', '-', '*', '~', '!', '?').contains(c);
    }

    public static ITokenList scan(CharSequence cs) throws LexicalError {
        // precondition: last character (if it exists) is a newline
        assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';

        ITokenList list = new ITokenList();
        int state = 0;
        StringBuffer lexAccu = null; // for constructing the identifier
        long numAccu = 0L; // for constructing the literal value

        for (int i = 0; i < cs.length(); i++) {
            char c = cs.charAt(i);
            // debug("char " + c);
            switch (state) {
                case 0:
                    if (Character.isDigit(c)) {
                        state = 2;
                        numAccu = Character.digit(c, 10);
                        //debug("0 -> 2 digit " + numAccu);
                    } else if (Character.isAlphabetic(c)) {
                        state = 1;
                        lexAccu = new StringBuffer(1024);
                        lexAccu.append(c);
                        //debug("0 -> 1 alphabetic " + lexAccu);
                    } else if (Character.isWhitespace(c)) {
                        // ignore
                    } else if (isSpecial(c)) {
                        state = 3;
                        lexAccu = new StringBuffer(1024);
                        lexAccu.append(c);
                    } else {
                        throw new LexicalError("illegal char: " + c);
                    }
                    break;
                case 1:
                    if (Character.isLetterOrDigit(c)){
                        //debug("1 digit " + lexAccu);
                        lexAccu.append(c);
                    } else {
                        state = 0;
                        i = i - 1;
                        debug("IDENT " + lexAccu);
                    }
                    break;
                case 2:
                    if (Character.isDigit(c)) {
                        int digit = Character.digit(c, 10);
                        numAccu = numAccu * 10 + digit;
                        //debug("2 digit " + numAccu);
                        if (numAccu > Integer.MAX_VALUE) {
                            throw new LexicalError("Integer literal too large!");
                        }
                    } else {
                        state = 0;
                        i = i - 1; // one back for next lexeme
                        debug("LITERAL " + numAccu);
                        list.add(new Literal(Terminals.LITERAL, (int) numAccu));
                    }
                    break;
                case 3:
                    if (isSpecial(c)){
                        lexAccu.append(c);
                    } else {
                        state = 0;
                        i = i - 1;
                        debug("OP " + lexAccu);
                    }
                    break;
                default:
                    throw new LexicalError("strange case entered: " + state);
            }
        }
        assert state == 0;
        list.add(new Base(Terminals.SENTINEL));
        return list;
    }
}
