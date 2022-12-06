package concreteSyntaxTree.nts;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import concreteSyntaxTree.interfaces.nts.IExpressionListLParenNTS;
import concreteSyntaxTree.interfaces.nts.IExpressionListNTS;
import java.util.ArrayList;

/*
exprListLParenNTS ::= [<expr> {',' <expr>}]
{',' <expr>} = exprListNTS
*/

public class ExpressionListLParenNTS extends Production implements IExpressionListLParenNTS {
    final IExpression N_expression;
    final IExpressionListNTS N_expressionListNTS;

    public ExpressionListLParenNTS(final IExpression N_expression, final IExpressionListNTS N_expressionListNTS) {
        this.N_expression = N_expression;
        this.N_expressionListNTS = N_expressionListNTS;
    }

    @Override public ArrayList<abstractSyntaxTree.interfaces.IExpression> toAbstractSyntax() {
        ArrayList<abstractSyntaxTree.interfaces.IExpression> temp = new ArrayList<>();
        temp.add(N_expression.toAbstractSyntax());
        return N_expressionListNTS.toAbstractSyntax(temp);
    }
}