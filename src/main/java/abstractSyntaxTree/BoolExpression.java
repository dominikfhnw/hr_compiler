package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class BoolExpression implements IExpression {

    Operators boolOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public BoolExpression(Operators boolOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.boolOpr = boolOpr;
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
