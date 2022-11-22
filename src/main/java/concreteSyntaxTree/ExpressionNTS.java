package concreteSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IExpressionNTS;
import concreteSyntaxTree.interfaces.ITerm1;
import scanner.interfaces.IToken;

// exprNTS ::= BOOLOPR term1 exprNTS

public class ExpressionNTS extends Production implements IExpressionNTS {
    final IToken T_boolOpr;
    final ITerm1 N_term1;
    final IExpressionNTS N_exprNTS;

    public ExpressionNTS(IToken T_boolOpr, ITerm1 N_term1, IExpressionNTS N_exprNTS) {
        this.T_boolOpr = T_boolOpr;
        this.N_term1 = N_term1;
        this.N_exprNTS = N_exprNTS;
    }

    // needs to be implemented
    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        return null;
    }
}