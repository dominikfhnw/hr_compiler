package concreteSyntaxTree.interfaces.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITerm2 extends IProduction {

    IExpression toAbstractSyntax();

}
