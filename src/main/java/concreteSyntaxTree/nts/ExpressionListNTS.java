package concreteSyntaxTree.nts;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IExpressionListNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

// expressionListNTS ::= COMMA expression expressionListNTS

public class ExpressionListNTS extends Production implements IExpressionListNTS {
    final IToken T_comma;
    final IExpression N_expression;
    final IExpressionListNTS N_expressionListNTS;

    public ExpressionListNTS(IToken T_comma, IExpression N_expression, IExpressionListNTS N_expressionListNTS) {
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