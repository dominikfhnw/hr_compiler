package scanner;

import errors.LexicalError;
import scanner.enums.Operators;
import scanner.enums.Terminals;
import scanner.interfaces.IToken;

import java.util.Arrays;

public class Scanner {

    public static void debug(String msg){
        System.out.println(msg);
    }

    /**
     * Converts a sequence of characters to tokens.
     * @param cs charSequence
     * @return List of tokens
     */
    public static ITokenList scan(CharSequence cs) throws LexicalError {
        // precondition: last character (if it exists) is a newline
        assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';

        ITokenList list = new ITokenList();
        int state = 0;
        StringBuffer lexAccu = null;    // for constructing the identifier
        StringBuffer symAccu = null;    // for constructing the special symbol
        long numAccu = 0L;              // for constructing the literal value

        for (int i = 0; i < cs.length(); i++) {
            char c = cs.charAt(i);
            // debug("char " + c);
            switch (state) {
                case 0: // state 0 = scan next token
                    if (Character.isDigit(c)) {
                        state = 2;
                        numAccu = Character.digit(c, 10);
                        //debug("0 -> 2 digit " + numAccu);
                    } else if (Character.isAlphabetic(c)) {
                        state = 1;
                        lexAccu = new StringBuffer(1024);
                        lexAccu.append(c);
                        //debug("0 -> 1 alphabetic " + lexAccu);
                    } else if (isSpecial(c)) {
                        state = 3;
                        symAccu = new StringBuffer(1024);
                        symAccu.append(c);
                    } else if (Character.isWhitespace(c)) {
                        "".isBlank(); // ignore whitespace (stay in state 0 and do nothing)
                    } else {
                        throw new LexicalError("illegal char: " + c);
                    }
                    break;
                case 1: // state 1 = scan identifier
                    if (Character.isLetterOrDigit(c)){
                        //debug("1 digit " + lexAccu);
                        lexAccu.append(c);
                    } else {
                        state = 0;
                        i = i - 1;
                        debug("IDENT " + "\t" + "\t" + lexAccu);
                        if(Terminals.isKeyword(String.valueOf(lexAccu))){
                            IToken token = Terminals.valueOfString(String.valueOf(lexAccu));
                            list.add(token);
                        } else if (Operators.isKeyword(String.valueOf(lexAccu))){
                            IToken token = Operators.valueOf(String.valueOf(lexAccu));
                            list.add(token);
                        }
                    }
                    break;
                case 2: // state 2 = scan literal
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
                        debug("LITERAL " + "\t" + numAccu);
                        list.add(new Literal(Terminals.LITERAL, (int) numAccu));
                    }
                    break;
                case 3: // state 3 = scan symbol
                    if (isSpecial(c) && Operators.isSubsequentSymbol(c, symAccu) ){
                    state = 0;
                    symAccu.append(c);
                    IToken token = Terminals.valueOfString(String.valueOf(symAccu));
                    list.add(token);
                    } else {
                        state = 0;
                        i = i - 1; // one back for next lexeme
                        debug("OP " + "\t" + "\t" + "\t" + symAccu);
                        // IToken token = Terminals.valueOf(String.valueOf(symAccu));
                        // list.add(token);
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

    /**
     * Checks if char is a non-alphabetic symbol.
     * @param c current char
     * @return True if char is a non-alphabetic symbol.
     */

    public static boolean isSpecial(char c){
        return Arrays.stream(Operators.values()).anyMatch(operators -> operators.getSymbol() == c) ||
            Arrays.stream(Terminals.values()).anyMatch(terminals -> terminals.getSymbol() == c);
    }
}
