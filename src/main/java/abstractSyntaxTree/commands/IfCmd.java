package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyInitializedError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;

// needs to be implemented

public class IfCmd implements ICmd {

    IExpression expression;
    CpsCmd ifCpsCmd;
    CpsCmd elseCpsCmd;

    public IfCmd(IExpression expression, CpsCmd ifCpsCmd, CpsCmd elseCpsCmd) {
        this.expression = expression;
        this.ifCpsCmd = ifCpsCmd;
        this.elseCpsCmd = elseCpsCmd;
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

    @Override
    public void checkInit() throws NotInitializedError, AlreadyInitializedError {

    }

    @Override
    public void setInit(TypeIdent ident) {

    }
}
