package concreteSyntaxTree.nts;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsCmd;
import abstractSyntaxTree.commands.CpsCmd;
import concreteSyntaxTree.interfaces.IIfElseNTS;
import scanner.interfaces.IToken;

/* ifElseNTS ::= else <cpsCmd> */

public class IfElseNTS extends Production implements IIfElseNTS {
    final IToken T_else;
    final ICpsCmd N_cpsCmd;

    public IfElseNTS(final IToken T_else, final ICpsCmd N_cpsCmd) {
        this.T_else = T_else;
        this.N_cpsCmd = N_cpsCmd;
    }

    @Override
    public CpsCmd toAbstractSyntax() {
        return N_cpsCmd.toAbstractSyntax();
    }
}