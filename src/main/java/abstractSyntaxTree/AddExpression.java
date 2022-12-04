package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class AddExpression implements IExpression {

    private Operators addOpr;
    private IExpression expressionLeft;
    private IExpression expressionRight;
    private Types castType;

    public AddExpression(Operators addOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.addOpr = addOpr;
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
