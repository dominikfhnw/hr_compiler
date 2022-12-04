package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;

// needs to be implemented

public class AssignCmd implements ICmd {

    IExpression expressionLeft;
    IExpression expressionRight;

    public AssignCmd(IExpression expressionLeft, IExpression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

}
