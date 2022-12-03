    package scanner.enums;

    import scanner.interfaces.IToken;

    import java.util.Arrays;

    public enum Terminals implements IToken {

        IDENT("ident"),
        LITERAL("literal"),
        TYPE("type"),

        // Operators
        ADDOPR("addOpr"),
        CUSTOPR("custOpr"),
        BOOLOPR("boolOpr"),
        MULTOPR("multOpr"),
        RELOPR("relOpr"),

        // Modes
        CHANGEMODE("changeMode"),
        FLOWMODE("flowMode"),
        MECHMODE("mechMode"),

        // Keywords
        CALL("call"),
        CASE("case"),
        CMD("cmd"),
        CPSCMD("cpsCmd"),
        CPSCMDNTS("cpsCmdNTS"),
        CPSDECL("cpsDecl"),
        CPSDECLNTS("cpsDeclNTS"),
        CPSSTODECL("cpsStoDecl"),
        CPSSTODECLNTS("cpsStoDeclNTS"),
        DEBUGIN("debugin"),
        DEBUGOUT("debugout"),
        DECL("decl"),
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
        FUNDECL("funDecl"),
        FUNDECLNTS("funDeclNTS"),
        GLOBAL("global"),
        GLOBALNTS("globalNTS"),
        IF("if"),
        INIT("init"),
        LOCAL("local"),
        NOTOPR("not"),
        PARAM("param"),
        PARAMLIST("paramList"),
        PARAMLISTNTS("paramListNTS"),
        PARAMNTS("paramNTS"),
        PROC("proc"),
        PROCDECL("procDecl"),
        PROCDECLNTS("procDeclNTS"),
        PROGRAM("program"),
        RETURNS("returns"),
        SENTINEL("sentinel"),
        SKIP("skip"),
        SWITCH("switch"),
        THEN("then"),
        WHILE("while"),

        // Symbols
        AMPERSAND("&"),
        BACKSLASH("\\"),
        COLON(":"),
        COMMA(","),
        EXCL("!"),
        LBRACE("{"),
        LBRACKET("["),
        LPAREN("("),
        RBRACE("}"),
        RBRACKET("]"),
        RPAREN(")"),
        SEMICOLON(";"),
        SEPARATOR("|"),
        SLASH("/"),
        STODECL("stoDecl"),
        TYPEDIDENT("typedIdent"),
        QUEST("?");
        /*
        CHANGEMODE_NTS(""),
        CMD(""),
        CPSCMD(""),
        CPSCMD_NTS(""),
        CPSDECL(""),
        CPSDECL_NTS(""),
        CPSSTODECL(""),
        CPSSTODECL_NTS(""),
        DECL(""),
        EXPR(""),
        EXPR_NTS(""),
        EXPRLIST(""),
        EXPRLIST_NTS(""),
        EXPRLISTLPAREN_NTS(""),
        FACTOR(""),
        FACTOR_NTS(""),
        FUNDECL(""),
        FUNDECL_NTS(""),
        IFELSE_NTS(""),
        MECHMODE_NTS(""),
        MONADICOPR(""),
        PARAM(""),
        PARAM_NTS(""),
        PARAMLIST(""),
        PARAMLIST_NTS(""),
        PROCDECL_NTS(""),
        TERM1(""),
        TERM1_NTS(""),
        TERM2(""),
        TERM2_NTS(""),
        TERM3(""),
        TERM3_NTS(""),
        TODECL(""),
        TYPEDIDENT("");*/

        final String stringValue;
        char charValue;
        Terminals(String stringValue) {
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

        public static boolean isKeyword(String lexeme){
            return Arrays.stream(Terminals.values()).anyMatch(terminals -> terminals.getLexeme().equals(lexeme));
        }

        @Override
        public String toString() {
            return name();
        }
    }
