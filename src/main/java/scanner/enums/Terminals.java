package scanner.enums;

import scanner.interfaces.IToken;

public enum Terminals implements IToken {

    IDENT("IDENT"),
    LITERAL("LITERAL"),
    TYPE("TYPE"),

    // scanner.enums.Operators
    ADDOPR("ADDOPR"),
    BOOLOPR("BOOLOPR"),
    MULTOPR("MULTOPR"),
    RELOPR("RELOPR"),

    // Symbols
    BECOMES(":="),
    COLON(":"),
    COMMA(","),
    LPAREN("("),
    RPAREN(")"),
    SEMICOLON(";"),

    // Modes
    CHANGEMODE("CHANGEMODE"),
    FLOWMODE("FLOWMODE"),
    MECHMODE("MECHMODE"),

    // Keywords
    CALL("CALL"),
    CASE("CASE"),
    DEBUGIN("DEBUGIN"),
    DEBUGOUT("DEBUGOUT"),
    DEFAULT("DEFAULT"),
    DO("DO"),
    ENDFUN("ENDFUN"),
    ENDIF("ENDIF"),
    ENDPROC("ENDPROC"),
    ENDPROGRAM("ENDPROGRAM"),
    ENDSWITCH("ENDSWITCH"),
    ENDWHILE("ENDWHILE"),
    ELSE("ELSE"),
    ELSEIF("ELSEIF"),
    FUN("FUN"),
    GLOBAL("GLOBAL"),
    IF("IF"),
    INIT("INIT"),
    LOCAL("LOCAL"),
    NOT("NOT"),
    PROC("PROC"),
    PROGRAM("PROGRAM"),
    RETURNS("RETURNS"),
    SENTINEL("SENTINEL"),
    SKIP("SKIP"),
    SWITCH("SWITCH"),
    THEN("THEN"),
    WHILE("WHILE");

    Terminals(String name) {
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
