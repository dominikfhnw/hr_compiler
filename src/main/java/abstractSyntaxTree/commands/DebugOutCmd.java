package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;

// toString must be implemented

public class DebugOutCmd implements ICmd {

    IExpression expression;

    public DebugOutCmd(IExpression expression) {
        this.expression = expression;
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
