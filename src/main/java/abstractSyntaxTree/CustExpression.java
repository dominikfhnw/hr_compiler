package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class CustExpression implements IExpression {

    Operators custOpr;
    private IExpression expressionLeft;
    private IExpression expressionRight;
    private Types castType;

    public CustExpression(Operators custOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.custOpr = custOpr;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public Types getType() {
        return null;
    }

    @Override
    public LRValue getLRValue() {
        return null;
    }

    @Override
    public void doTypeCast(Types type) {

    }

}
