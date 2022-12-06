package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.Types;

// toString must be implemented

public class WhileCmd implements ICmd {

    IExpression expression;
    CpsCmd cpsCmd;

    public WhileCmd(IExpression expression, CpsCmd cpsCmd) {
        this.expression = expression;
        this.cpsCmd = cpsCmd;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
        cpsCmd.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
        cpsCmd.checkType();
        if (expression.getType() != Types.BOOL)
            throw new TypeCheckError(Types.BOOL, expression.getType());
    }

}
