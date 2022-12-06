package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.interfaces.IFactor;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Types;

// toString must be implemented

public class ExpressionFactor implements IFactor {

    IExpression expression;

    public ExpressionFactor(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public Types getType() {
        return expression.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
