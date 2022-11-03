package scanner.enums;

import scanner.interfaces.IToken;

public enum Types implements IToken {

    BOOL,
    INT32;

    @Override
    public String getLexeme() {
        return null;
    }

    @Override
    public char getSymbol() {
        return 0;
    }

    @Override
    public boolean isLexeme() {
        return false;
    }

    @Override
    public boolean isSymbol() {
        return false;
    }
}
