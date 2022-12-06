package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

public interface IExpressionNTS extends IProduction {

    IExpression toAbstractSyntax(IExpression expression);

}
