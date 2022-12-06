package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITerm3NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}