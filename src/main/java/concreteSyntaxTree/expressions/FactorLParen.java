package concreteSyntaxTree.expressions;

import abstractSyntaxTree.factors.ExpressionFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import concreteSyntaxTree.interfaces.expressions.IFactor;
import scanner.interfaces.IToken;

/* <factor> ::= '(' <expr> ')' */

public class FactorLParen extends Production implements IFactor {
    final IToken T_lParen;
    final IExpression N_expression;
    final IToken T_rParen;

    public FactorLParen(final IToken T_lParen, final IExpression N_expression, final IToken T_rParen) {
        this.T_lParen = T_lParen;
        this.T_rParen = T_rParen;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new ExpressionFactor(N_expression.toAbstractSyntax());
    }
}