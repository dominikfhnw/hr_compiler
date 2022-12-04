package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IExpression;
import java.util.ArrayList;

public interface IExpressionListLParenNTS extends IProduction {

    public ArrayList<IExpression> toAbstractSyntax();

}
