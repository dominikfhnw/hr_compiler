package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

// methods must be implemented

public class AddExpression implements IExpression {

    Operators addOpr;
    IExpression expressionLeft;
    IExpression expressionRight;

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
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {

    }

    @Override
    public void checkType() throws TypeCheckError {

    }

}
