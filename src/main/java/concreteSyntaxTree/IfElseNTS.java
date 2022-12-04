package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICpsCmd;
import abstractSyntaxTree.CpsCmd;
import concreteSyntaxTree.interfaces.IIfElseNTS;
import scanner.interfaces.IToken;

// ifelseNTS ::= ELSE cpsCmd

public class IfElseNTS extends Production implements IIfElseNTS {
    final IToken T_else;
    final ICpsCmd N_cpsCmd;

    public IfElseNTS(IToken T_else, ICpsCmd N_cpsCmd) {
        this.T_else = T_else;
        this.N_cpsCmd = N_cpsCmd;
    }

    @Override
    public CpsCmd toAbstractSyntax() {
        return N_cpsCmd.toAbstractSyntax();
    }
}