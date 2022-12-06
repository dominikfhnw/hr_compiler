package concreteSyntaxTree.expressions;

import abstractSyntaxTree.factors.ExpressionFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IFactor;
import scanner.interfaces.IToken;

/* <factor> ::= '(' <expr> ')' */

public class FactorLParen extends Production implements IFactor {
    final IToken T_lParen;
    final IExpression N_expression;
    final IToken T_rParen;

    public FactorLParen(IToken T_lParen, IExpression N_expression, IToken T_rParen) {
        this.T_lParen = T_lParen;
        this.T_rParen = T_rParen;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new ExpressionFactor(N_expression.toAbstractSyntax());
    }
}