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

    Operators(String name) {
    }

    @Override
    public String toString() {
        return name();
    }
}