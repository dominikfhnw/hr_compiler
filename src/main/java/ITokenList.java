public interface ITokenList {

    //for constructing the token list by the scanner
    void add(IToken token);
    // for reading the token list by the parser
    void reset();
    // for reading the token list by the parser
    IToken nextToken();
    // for displaying the token list
    String toString();

}
