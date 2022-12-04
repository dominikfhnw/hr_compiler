package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;

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

}
