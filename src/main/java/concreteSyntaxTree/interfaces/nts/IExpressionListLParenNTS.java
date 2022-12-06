package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IExpressionListLParenNTS extends IProduction {

    ArrayList<IExpression> toAbstractSyntax();

}
