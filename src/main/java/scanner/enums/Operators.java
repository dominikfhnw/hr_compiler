package scanner.enums;

import scanner.interfaces.IToken;

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
        if (isLexeme()) {
            return stringValue;
        }
        return stringValue;
    }

    @Override
    public boolean isSymbol() {
        return stringValue.length() == 1 && !isLexeme();
    }

    @Override
    public char getSymbol() {
        if (isSymbol()) {
            charValue = stringValue.charAt(0);
        }
        return charValue;
    }

    @Override
    public String toString() {
        return name();
    }
}