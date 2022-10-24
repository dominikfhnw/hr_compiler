package scanner;

import scanner.interfaces.IToken;
import java.util.ArrayList;

public class ITokenList {

    private final ArrayList<IToken> tokenList = new ArrayList<>();
    private int position = 0;

    //for constructing the token list by the scanner
    public void add(IToken token) {
        tokenList.add(token);
    }

    // for reading the token list by the parser
    public void reset() {
        position = 0;
    }

    // for reading the token list by the parser
    public IToken nextToken() {
        return tokenList.get(position++);
    }

    // for displaying the token list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (IToken token : tokenList) {
            sb.append(token.toString());
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
