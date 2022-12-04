package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class RelExpression implements IExpression {

    Operators relOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public RelExpression(Operators relOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.relOpr = relOpr;
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
