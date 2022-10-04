import java.util.ArrayList;

public interface ITokenList {

    //for constructing the token list by the scanner
    void add(IToken.Base token);
    // for reading the token list by the parser
    void reset();
    // for reading the token list by the parser
    IToken.Base nextToken();
    // for displaying the token list
    String toString();

}
