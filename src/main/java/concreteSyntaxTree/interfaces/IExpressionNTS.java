package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface IExpressionNTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}
