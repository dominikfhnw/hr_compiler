package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;

// needs to be implemented

public class WhileCmd implements ICmd {

    IExpression expression;
    CpsCmd cpsCmd;

    public WhileCmd(IExpression expression, CpsCmd cpsCmd) {
        this.expression = expression;
        this.cpsCmd = cpsCmd;
    }

}
