package concreteSyntaxTree;
import concreteSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IExpressionNTS;
import concreteSyntaxTree.interfaces.ITerm1;

public class Expression extends Production implements IExpression {

    private final ITerm1 term1;
    private final IExpressionNTS expressionNTS;

    public Expression(ITerm1 term1, IExpressionNTS expressionNTS) {
        this.term1 = term1;
        this.expressionNTS = expressionNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return expressionNTS.toAbstractSyntax(term1.toAbstractSyntax());
    }

}
