package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IExpression;
import java.util.ArrayList;

public interface IExpressionList extends IProduction {

    ArrayList<IExpression> toAbstractSyntax();

}
