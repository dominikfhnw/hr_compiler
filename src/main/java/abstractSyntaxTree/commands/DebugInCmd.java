package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyInitializedError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import scanner.enums.LRValue;

// needs to be implemented

public class DebugInCmd implements ICmd {

    IExpression expression;

    public DebugInCmd(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
        if (expression.getLRValue() != LRValue.LVALUE)
            throw new LRValueError(LRValue.LVALUE, expression.getLRValue());
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
    }

    @Override
    public void checkInit() throws NotInitializedError, AlreadyInitializedError {

    }

    @Override
    public void setInit(TypeIdent ident) {

    }
}
