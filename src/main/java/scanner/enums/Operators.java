package scanner.enums;

import scanner.interfaces.IToken;

import java.util.Arrays;

public enum Operators implements IToken {

    AND("/\\"),
    BECOMES(":="),
    CAND("/\\?"),
    COR("\\/?"),
    DIV_E("divE"),
    DIV_F("divF"),
    DIV_T("divT"),
    EQ("=="),
    GE(">="),
    GT(">"),
    LE("<="),
    LT("<"),
    MINUS("-"),
    MOD_E("modE"),
    MOD_F("modF"),
    MOD_T("modT"),
    NE("!="),
    NOT("~"),
    OR("\\/"),
    PLUS("+"),
    TIMES("*");

    final String stringValue;
    char charValue;

    Operators(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public boolean isLexeme() {
        char [] lexeme = stringValue.toCharArray();
        int numberOfLetters = 0;
        for (char letter : lexeme) {
            if (Character.isLetter(letter)) {
                numberOfLetters++;
            }
        }
        return numberOfLetters == stringValue.length();
    }
    @Override
    public String getLexeme() {
        isLexeme();
        return stringValue;
    }

    @Override
    public boolean isSymbol() {
        return stringValue.length() == 1 && !isLexeme();
    }

    @Override
    public char getSymbol() {
        isSymbol();
        return charValue = stringValue.charAt(0);
    }

    /**
     * Checks if the lexeme is a keyword.
     * @param lexeme the current lexeme to be checked
     * @return True if the lexeme is a keyword of IML.
     */
    public static boolean isKeyword(String lexeme){
        return Arrays.stream(Operators.values()).anyMatch(operators -> operators.getLexeme().equals(lexeme));
    }

    /**
     * Checks if char is a subsequent symbol.
     * @param c Character to check
     * @return True if char is a subsequent symbol which follows a previous symbol.
     */

    public static boolean isSubsequentSymbol(char c, StringBuffer previous) {
        assert previous != null;
        return switch (previous.toString()) {
            case "/", ">", "<", ":", "!" -> c == '=';
            case "&" -> c == '&';
            case "|" -> c == '|';
            default -> false;
        };
    }

    @Override
    public String toString() {
        return name();
    }
}