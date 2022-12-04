package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class MultExpression implements IExpression {

    Operators multOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public MultExpression(Operators multOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.multOpr = multOpr;
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