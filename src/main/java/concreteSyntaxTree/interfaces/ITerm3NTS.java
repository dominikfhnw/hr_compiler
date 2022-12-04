package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm3NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}