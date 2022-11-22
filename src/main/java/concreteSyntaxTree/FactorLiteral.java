package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import scanner.interfaces.IToken;
import scanner.Literal;

// factor ::= LITERAL

public class FactorLiteral extends Production implements IFactor {

    final IToken T_literal;

    public FactorLiteral(IToken T_literal) {
        this.T_literal = T_literal;
    }

    // needs to be implemented
    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return null;
    }
}