package concreteSyntaxTree.nts;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import concreteSyntaxTree.interfaces.nts.IExpressionListNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

/* exprListNTS ::= {',' <expr>} */

public class ExpressionListNTS extends Production implements IExpressionListNTS {
    final IToken T_comma;
    final IExpression N_expression;
    final IExpressionListNTS N_expressionListNTS;

    public ExpressionListNTS(final IToken T_comma, final IExpression N_expression, final IExpressionListNTS N_expressionListNTS) {
        this.T_comma = T_comma;
        this.N_expression = N_expression;
        this.N_expressionListNTS = N_expressionListNTS;
    }

    @Override
    public ArrayList<abstractSyntaxTree.interfaces.IExpression> toAbstractSyntax(
        ArrayList<abstractSyntaxTree.interfaces.IExpression> temp) {
        temp.add(N_expression.toAbstractSyntax());
        return N_expressionListNTS.toAbstractSyntax(temp);
    }
}