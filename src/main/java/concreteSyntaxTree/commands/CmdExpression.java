package concreteSyntaxTree.commands;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.IExpression;
import scanner.interfaces.IToken;

// cmd ::= expr BECOMES expr

public class CmdExpression extends Production implements ICmd {

    final IExpression N_expression1;
    final IToken T_becomes;
    final IExpression N_expression2;

    public CmdExpression(IExpression N_expression1, IToken T_becomes, IExpression N_expression2) {
        this.N_expression1 = N_expression1;
        this.T_becomes = T_becomes;
        this.N_expression2 = N_expression2;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return null; // needs to be fixed
        // return new AssignCmd(N_expression1.toAbstractSyntax(), N_expression2.toAbstractSyntax());
    }
}