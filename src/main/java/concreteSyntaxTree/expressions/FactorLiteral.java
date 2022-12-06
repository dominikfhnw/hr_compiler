package concreteSyntaxTree.expressions;

import abstractSyntaxTree.factors.LiteralFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IFactor;
import scanner.interfaces.IToken;
import scanner.Literal;

/* <factor> ::= <literal> */

public class FactorLiteral extends Production implements IFactor {

    final IToken T_literal;

    public FactorLiteral(final IToken T_literal) {
        this.T_literal = T_literal;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new LiteralFactor((Literal) T_literal);
    }
}