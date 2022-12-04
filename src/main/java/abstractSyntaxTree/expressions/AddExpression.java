package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class AddExpression implements IExpression {

    Operators addOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public AddExpression(Operators addOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.addOpr = addOpr;
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
