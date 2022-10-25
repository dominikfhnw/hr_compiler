package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm2NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}