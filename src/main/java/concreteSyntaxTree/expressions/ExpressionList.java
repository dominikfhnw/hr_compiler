package concreteSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IExpressionList;
import concreteSyntaxTree.interfaces.nts.IExpressionListLParenNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

/*
<exprList> ::= '(' [<expr> {',' <expr>}] ')'
'(' [<expr> {',' <expr>}] ')' = exprListLParenNTS
*/

public class ExpressionList extends Production implements IExpressionList {
    final IToken T_lParen;
    final IExpressionListLParenNTS N_expressionListLParenNTS;
    final IToken T_rParen;

    public ExpressionList(final IToken T_lParen, final IExpressionListLParenNTS N_exprListLparenNTS, final IToken T_rParen) {
        this.T_lParen = T_lParen;
        this.T_rParen = T_rParen;
        this.N_expressionListLParenNTS = N_exprListLparenNTS;
    }

    @Override public ArrayList<IExpression> toAbstractSyntax() {
        return N_expressionListLParenNTS.toAbstractSyntax();
    }
}