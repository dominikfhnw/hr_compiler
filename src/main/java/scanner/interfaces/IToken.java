package scanner.interfaces;

public interface IToken {

    String getLexeme();
    char getSymbol();

    boolean isLexeme();

    boolean isSymbol();
}