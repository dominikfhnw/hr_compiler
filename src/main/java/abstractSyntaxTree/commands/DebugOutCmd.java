package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;

// needs to be implemented

public class DebugOutCmd implements ICmd {

    IExpression expression;

    public DebugOutCmd(IExpression expression) {
        this.expression = expression;
    }

}
