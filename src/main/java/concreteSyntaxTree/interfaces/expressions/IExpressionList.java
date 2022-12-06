package concreteSyntaxTree.interfaces.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IExpressionList extends IProduction {

    ArrayList<IExpression> toAbstractSyntax();

}
