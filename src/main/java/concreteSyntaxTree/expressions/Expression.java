package concreteSyntaxTree.expressions;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IExpressionNTS;
import concreteSyntaxTree.interfaces.ITerm1;

/*
<expr> ::= <term1> ({'/\?' <term1>} | {'\/?' <term1>})
({'/\?' <term1>} | {'\/?' <term1>}) = expressionNTS
*/

public class Expression extends Production implements IExpression {

    final ITerm1 N_term1;
    final IExpressionNTS N_expressionNTS;

    public Expression(ITerm1 N_term1, IExpressionNTS N_expressionNTS) {
        this.N_term1 = N_term1;
        this.N_expressionNTS = N_expressionNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_expressionNTS.toAbstractSyntax(N_term1.toAbstractSyntax());
    }

}
