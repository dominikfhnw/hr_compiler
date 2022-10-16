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
            isLexeme(); //
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

        @Override
        public String toString() {
            return name();
        }
    }
