package concreteSyntaxTree.commands;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IIfElseNTS;
import scanner.interfaces.IToken;

// cmd ::= IF expr THEN cpsCmd ifelseNTS ENDIF

public class CmdIfThen extends Production implements ICmd {
    final IToken T_if;
    final IExpression N_expression;
    final IToken T_then;
    final ICpsCmd N_cpsCmd;
    final IIfElseNTS N_ifElseNTS;
    final IToken T_endIf;

    public CmdIfThen(IToken T_if, IExpression N_expression, IToken T_then, ICpsCmd N_cpsCmd, IIfElseNTS N_ifElseNTS, IToken T_endIf) {
        this.T_if = T_if;
        this.N_expression = N_expression;
        this.T_then = T_then;
        this.N_cpsCmd = N_cpsCmd;
        this.N_ifElseNTS = N_ifElseNTS;
        this.T_endIf = T_endIf;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return null; // needs to be fixed
        // return new IfCmd(N_expression.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax(), N_ifElseNTS.toAbstractSyntax());
    }
}