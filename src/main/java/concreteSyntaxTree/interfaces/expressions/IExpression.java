package concreteSyntaxTree.interfaces.expressions;

import concreteSyntaxTree.interfaces.IProduction;

public interface IExpression extends IProduction {

    abstractSyntaxTree.interfaces.IExpression toAbstractSyntax();

}
