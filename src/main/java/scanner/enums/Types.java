package scanner.enums;

import scanner.interfaces.IToken;

public enum Types implements IToken {

    INT,
    BOOL,
    INT32,
    INT64,
    INT1024;

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
