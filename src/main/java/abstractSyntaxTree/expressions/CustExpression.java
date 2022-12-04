package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class CustExpression implements IExpression {

    Operators custOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public CustExpression(Operators custOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.custOpr = custOpr;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    // needs to be implemented

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
