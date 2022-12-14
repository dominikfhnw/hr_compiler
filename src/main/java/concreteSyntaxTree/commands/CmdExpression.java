package concreteSyntaxTree.commands;

import abstractSyntaxTree.commands.AssignCmd;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import scanner.interfaces.IToken;

/* <cmd> ::= <expr> ':=' <expr> */

public class CmdExpression extends Production implements ICmd {

    final IExpression N_expression1;
    final IToken T_becomes;
    final IExpression N_expression2;

    public CmdExpression(final IExpression N_expression1, final IToken T_becomes, final IExpression N_expression2) {
        this.N_expression1 = N_expression1;
        this.T_becomes = T_becomes;
        this.N_expression2 = N_expression2;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return new AssignCmd(N_expression1.toAbstractSyntax(), N_expression2.toAbstractSyntax());
    }
}