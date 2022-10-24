package parser;

import scanner.Base;
import scanner.ITokenList;
import scanner.enums.Terminals;
import scanner.interfaces.IToken;

public class Parser implements IParser {

    private ITokenList tokenList;
    private Base currentToken;
    private Terminals currentTerminal;

    // private IConcSyn concSyn;

    public Parser(ITokenList tokenList) {
        this.tokenList = tokenList;
        this.tokenList.reset();
        currentToken = (Base) tokenList.nextToken();
        currentTerminal = currentToken.getTerminal();
        // conSyn = new ConSyn();
    }

}
