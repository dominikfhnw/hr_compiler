package concreteSyntaxTree.commands;

import abstractSyntaxTree.commands.DebugOutCmd;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.IExpression;
import scanner.interfaces.IToken;

/* <cmd> ::= debugout <expr> */

public class CmdDebugOut extends Production implements ICmd {
    protected final IToken T_debugOut;
    protected final IExpression N_expression;

    public CmdDebugOut(IToken T_debugOut, IExpression N_expression) {
        this.T_debugOut = T_debugOut;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return new DebugOutCmd(N_expression.toAbstractSyntax());
    }
}