package concreteSyntaxTree.nts;

import abstractSyntaxTree.expressions.BoolExpression;
import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IExpressionNTS;
import concreteSyntaxTree.interfaces.ITerm1;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* exprNTS ::= BOOLOPR term1 exprNTS */

public class ExpressionNTS extends Production implements IExpressionNTS {
    final IToken T_boolOpr;
    final ITerm1 N_term1;
    final IExpressionNTS N_expressionNTS;

    public ExpressionNTS(final IToken T_boolOpr, final ITerm1 N_term1, final IExpressionNTS N_expressionNTS) {
        this.T_boolOpr = T_boolOpr;
        this.N_term1 = N_term1;
        this.N_expressionNTS = N_expressionNTS;
    }

    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        IExpression temp = new BoolExpression(((Operator) T_boolOpr).getOperator(), expression, N_term1.toAbstractSyntax());
        return N_expressionNTS.toAbstractSyntax(temp);
    }
}