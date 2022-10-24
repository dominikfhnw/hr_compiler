package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm2NTS extends IProduction {

    public IExpression toAbstractSyntax(IExpression expression);

}