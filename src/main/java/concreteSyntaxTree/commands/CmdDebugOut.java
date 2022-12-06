package concreteSyntaxTree.commands;

import abstractSyntaxTree.commands.DebugOutCmd;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import scanner.interfaces.IToken;

/* <cmd> ::= debugout <expr> */

public class CmdDebugOut extends Production implements ICmd {
    final IToken T_debugOut;
    final IExpression N_expression;

    public CmdDebugOut(final IToken T_debugOut, final IExpression N_expression) {
        this.T_debugOut = T_debugOut;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return new DebugOutCmd(N_expression.toAbstractSyntax());
    }
}