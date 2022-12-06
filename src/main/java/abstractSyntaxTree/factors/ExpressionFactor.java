package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.interfaces.IFactor;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Types;

// methods must be implemented

public class ExpressionFactor implements IFactor {

    IExpression expression;

    public ExpressionFactor(IExpression expression) {
        this.expression = expression;
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
