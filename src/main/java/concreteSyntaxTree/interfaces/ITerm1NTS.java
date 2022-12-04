package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm1NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}
