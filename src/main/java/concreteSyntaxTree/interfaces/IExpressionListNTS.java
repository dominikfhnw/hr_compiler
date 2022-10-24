package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;

import java.util.ArrayList;

public interface IExpressionListNTS extends IProduction {

    public ArrayList<IExpression> toAbstractSyntax(ArrayList<IExpression> expressionList);

}
