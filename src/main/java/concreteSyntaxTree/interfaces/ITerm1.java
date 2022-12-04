package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IExpression;

public interface ITerm1 extends IProduction {

    IExpression toAbstractSyntax();

}