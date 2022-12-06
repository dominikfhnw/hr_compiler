package concreteSyntaxTree.commands;

import abstractSyntaxTree.commands.DebugInCmd;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import scanner.interfaces.IToken;

/* <cmd> ::= debugin <expr> */

public class CmdDebugIn extends Production implements ICmd {
    final IToken T_debugIn;
    final IExpression N_expression;

    public CmdDebugIn(final IToken T_debugIn, final IExpression N_expression) {
        this.T_debugIn = T_debugIn;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return new DebugInCmd(N_expression.toAbstractSyntax());
    }
}