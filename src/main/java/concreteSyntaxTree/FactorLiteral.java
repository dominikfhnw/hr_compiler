package concreteSyntaxTree;

import abstractSyntaxTree.LiteralFactor;
import concreteSyntaxTree.interfaces.IFactor;
import scanner.interfaces.IToken;
import scanner.Literal;

// factor ::= LITERAL

public class FactorLiteral extends Production implements IFactor {

    final IToken T_literal;

    public FactorLiteral(IToken T_literal) {
        this.T_literal = T_literal;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new LiteralFactor((Literal) T_literal);
    }
}