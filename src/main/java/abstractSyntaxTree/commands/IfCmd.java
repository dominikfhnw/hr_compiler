package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.Types;

// toString must be implemented

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
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
        ifCpsCmd.checkScope();
        elseCpsCmd.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
        ifCpsCmd.checkType();
        elseCpsCmd.checkType();
        if (expression.getType() != Types.BOOL)
            throw new TypeCheckError(Types.BOOL, expression.getType());
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
