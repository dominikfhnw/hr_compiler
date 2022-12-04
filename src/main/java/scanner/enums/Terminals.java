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
        MECHMODE("mechMode"),

        // Keywords
        BECOMES("becomes"),
        CALL("call"),
        CASE("case"),
        CHANGEMODENTS("changeModeNTS"),
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
        EXPR("expr"),
        EXPRNTS("exprNTS"),
        EXPRLIST("exprList"),
        EXPRLISTNTS("exprListNTS"),
        EXPRLISTLPARENNTS("exprListLParenNTS"),
        FACTOR("factor"),
        FACTORNTS("factorNTS"),
        FUN("fun"),
        FUNDECL("funDecl"),
        FUNDECLNTS("funDeclNTS"),
        GLOBAL("global"),
        GLOBALNTS("globalNTS"),
        IF("if"),
        IFELSENTS("ifElseNTS"),
        INIT("init"),
        LOCAL("local"),
        MECHMODENTS("mechModeNTS"),
        MONADICOPR("monadicOpr"),
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
        TERM1("term1"),
        TERM1NTS("term1NTS"),
        TERM2("term2"),
        TERM2NTS("term2NTS"),
        TERM3("term3"),
        TERM3NTS("term3NTS"),
        TERM4("term4"),
        TERM4NTS("term4NTS"),
        TYPEDIDENT("typedIdent"),
        QUEST("?");

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
