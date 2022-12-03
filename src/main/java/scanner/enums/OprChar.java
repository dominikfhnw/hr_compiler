package scanner.enums;

import scanner.interfaces.IToken;

import java.util.Arrays;

public enum OprChar implements IToken {

    AMPERSAND("&"),
    BACKSLASH("\\"),
    EXCL("!"),
    SEPARATOR("|"),
    SLASH("/"),
    QUEST("?"),
    HASHTAG("#"),
    TIMES("*"),
    PLUS("+"),
    MINUS("-"),
    NOT("~"),
    AT("@"),
    GT(">"),
    LT("<"),
    EQUAL("="),
    UNDERSCORE("_"),
    PERCENT("%"),
    DOLLAR("$"),
    CIRCUMFLEX("^");

    String stringValue;
    char charValue;

    OprChar(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String getLexeme() {
        return null;
    }

    @Override
    public char getSymbol() {
        isSymbol();
        return charValue = stringValue.charAt(0);
    }

    @Override
    public boolean isLexeme() {
        return false;
    }

    @Override
    public boolean isSymbol() {
        return stringValue.length() == 1;
    }

    public static boolean isSubsequentRegularOperatorSymbol(char c, StringBuffer previous) {
        assert previous != null;
        return switch (previous.toString()) {
            case "/", ">", "<", ":", "!" -> c == '=';
            case "&" -> c == '&';
            case "|" -> c == '|';
            default -> false;
        };
    }

    public boolean isOprChar(char c) {
        if (Arrays.stream(Operators.values()).anyMatch(operators -> operators.getLexeme().equals(stringValue)) &&
            isSubsequentRegularOperatorSymbol(c, new StringBuffer(stringValue))) {
            return false;
        } else if (Arrays.stream(Operators.values()).anyMatch(operators -> operators.getLexeme().equals(stringValue)) && Arrays.stream(Terminals.values()).anyMatch(terminals -> terminals.getLexeme().equals(stringValue))) {
            return false;
        }
        return true;
    }

}
