package concreteSyntaxTree.interfaces.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITerm1 extends IProduction {

    IExpression toAbstractSyntax();

}