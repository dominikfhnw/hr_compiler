package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface IExpressionNTS extends IProduction {

    public IExpression toAbstractSyntax(IExpression expression);

}
