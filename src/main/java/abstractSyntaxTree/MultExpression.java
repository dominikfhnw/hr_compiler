package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class MultExpression implements IExpression {

    private Operators multOpr;
    private IExpression expressionLeft;
    private IExpression expressionRight;
    private Types castType;

    public MultExpression(Operators multOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.multOpr = multOpr;
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