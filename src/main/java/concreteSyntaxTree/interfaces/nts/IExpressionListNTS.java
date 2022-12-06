package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IExpressionListNTS extends IProduction {

    ArrayList<IExpression> toAbstractSyntax(ArrayList<IExpression> expressionList);

}
