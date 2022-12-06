package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITerm2NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}