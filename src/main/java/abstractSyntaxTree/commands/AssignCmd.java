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

public class AssignCmd implements ICmd {

    IExpression expressionLeft;
    IExpression expressionRight;

    public AssignCmd(IExpression expressionLeft, IExpression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError,LRValueError {
        expressionLeft.checkScope();
        expressionRight.checkScope();
        if (expressionLeft.getLRValue() == LRValue.RVALUE){
            throw new LRValueError(LRValue.LVALUE, expressionLeft.getLRValue());
        }
    }

    @Override
    public void checkType() throws TypeCheckError {
        expressionLeft.checkType();
        expressionRight.checkType();
        if (expressionLeft.getType() != expressionRight.getType()) {
            throw new TypeCheckError(expressionLeft.getType(), expressionRight.getType());
        }
    }

    @Override
    public void checkInit() throws NotInitializedError, AlreadyInitializedError {

    }

    @Override
    public void setInit(TypeIdent ident) {

    }
}
