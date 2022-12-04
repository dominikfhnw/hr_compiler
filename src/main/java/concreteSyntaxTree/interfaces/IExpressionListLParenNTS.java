package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IExpression;
import java.util.ArrayList;

public interface IExpressionListLParenNTS extends IProduction {

    ArrayList<IExpression> toAbstractSyntax();

}
