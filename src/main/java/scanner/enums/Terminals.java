package scanner.enums;

import scanner.interfaces.IToken;

public enum Terminals implements IToken {

    IDENT("ident"),
    LITERAL("literal"),
    TYPE("type"),

    // Operators
    ADDOPR("addOpr"),
    BOOLOPR("boolOpr"),
    MULTOPR("multOpr"),
    RELOPR("relOpr"),

    // Symbols
    BECOMES(":="),
    COLON(":"),
    COMMA(","),
    LPAREN("("),
    RPAREN(")"),
    SEMICOLON(";"),

    // Modes
    CHANGEMODE("changeMode"),
    FLOWMODE("flowMode"),
    MECHMODE("mechMode"),

    // Keywords
    CALL("call"),
    CASE("case"),
    DEBUGIN("debugin"),
    DEBUGOUT("debugout"),
    DEFAULT("default"),
    DO("do"),
    ENDFUN("endfun"),
    ENDIF("endif"),
    ENDPROC("endproc"),
    ENDPROGRAM("endprogram"),
    ENDSWITCH("endswitch"),
    ENDWHILE("endwhile"),
    ELSE("else"),
    ELSEIF("elseif"),
    FUN("fun"),
    GLOBAL("global"),
    IF("if"),
    INIT("init"),
    LOCAL("local"),
    NOT("not"),
    PROC("proc"),
    PROGRAM("program"),
    RETURNS("returns"),
    SENTINEL("sentinel"),
    SKIP("skip"),
    SWITCH("switch"),
    THEN("then"),
    WHILE("while");

    Terminals(String name) {
    }
}
