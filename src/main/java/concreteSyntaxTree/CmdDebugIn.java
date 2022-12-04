package concreteSyntaxTree;

// cmd ::= DEBUGIN expr

import abstractSyntaxTree.DebugInCmd;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.IExpression;
import scanner.interfaces.IToken;

public class CmdDebugIn extends Production implements ICmd {
    final IToken T_debugIn;
    final IExpression N_expression;

    public CmdDebugIn(IToken T_debugIn, IExpression N_expression) {
        this.T_debugIn = T_debugIn;
        this.N_expression = N_expression;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return null;
        // return new DebugInCmd(N_expression.toAbstractSyntax());
    }
}