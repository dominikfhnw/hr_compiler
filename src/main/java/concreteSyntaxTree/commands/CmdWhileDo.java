package concreteSyntaxTree.commands;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IExpression;
import scanner.interfaces.IToken;

/* <cmd> ::= while <expr> do <cpsCmd> endwhile */

public class CmdWhileDo extends Production implements ICmd {
    final IToken T_while;
    final IExpression N_expression;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endWhile;

    public CmdWhileDo(IToken T_while, IExpression N_expression, IToken T_do, ICpsCmd N_cpsCmd, IToken T_endWhile) {
        this.T_while = T_while;
        this.N_expression = N_expression;
        this.T_do = T_do;
        this.N_cpsCmd = N_cpsCmd;
        this.T_endWhile = T_endWhile;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return null; // needs to be fixed
        // return new WhileCmd(N_expression.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax());
    }
}