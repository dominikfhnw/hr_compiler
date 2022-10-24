package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm1NTS extends IProduction {

    public IExpression toAbstractSyntax(IExpression expression);

}
