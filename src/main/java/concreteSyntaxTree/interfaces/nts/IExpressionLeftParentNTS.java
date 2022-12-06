package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IExpressionLeftParentNTS extends IProduction {

    ArrayList<IExpression> toAbstractSyntax();

}
