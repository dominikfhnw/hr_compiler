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
    GT(">", '>'),
    LE("<="),
    LT("<", '<'),
    MINUS("-", '-'),
    MOD_E("modE"),
    MOD_F("modF"),
    MOD_T("modT"),
    NE("!="),
    NOT("~", '~'),
    OR("\\/"),
    PLUS("+", '+'),
    TIMES("*", '*');

    final String stringValue;
    char charValue;


    Operators(String stringValue) {
        this.stringValue = stringValue;
    }

    Operators(String stringValue, char charValue) {
        this.stringValue = stringValue;
        this.charValue = charValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public char getCharValue() {
        return charValue;
    }

    @Override
    public String toString() {
        return name();
    }
}