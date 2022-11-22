package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm4NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}