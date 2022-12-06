package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

// toString must be implemented

public class RelExpression implements IExpression {

    Operators relOpr;
    IExpression expressionLeft;
    IExpression expressionRight;

    public RelExpression(Operators relOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.relOpr = relOpr;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public Types getType() {
        return expressionLeft.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expressionLeft.checkScope();
        expressionRight.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expressionLeft.checkType();
        expressionRight.checkType();
        if (expressionLeft.getType() == Types.BOOL) {
            throw new TypeCheckError(Types.INT32, expressionLeft.getType());
        } else if (expressionLeft.getType() != expressionRight.getType()) {
            throw new TypeCheckError(expressionLeft.getType(), expressionRight.getType());
        }
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
