package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITerm1NTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}
