package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class MultExpression implements IExpression {

    Operators multOpr;
    IExpression expressionLeft;
    IExpression expressionRight;

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