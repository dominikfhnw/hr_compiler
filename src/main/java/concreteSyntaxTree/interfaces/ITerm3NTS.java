package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm3NTS extends IProduction {

    public IExpression toAbstractSyntax(IExpression expression);

}