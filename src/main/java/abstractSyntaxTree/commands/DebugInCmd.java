package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;

// needs to be implemented

public class DebugInCmd implements ICmd {

    IExpression expression;

    public DebugInCmd(IExpression expression) {
        this.expression = expression;
    }

}
