package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IProgram;
import scanner.Ident;
import scanner.interfaces.IToken;

/* <program> ::= program <ident> do <cpsCmd> endprogram */

public class Program extends Production implements IProgram {

    final IToken T_program;
    final IToken T_ident;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endprogram;

    public Program(IToken T_program, IToken T_ident, IToken T_do, ICpsCmd N_cpsCmd, IToken T_endprogram) {

        this.T_program = T_program;
        this.T_ident = T_ident;
        this.T_do = T_do;
        this.N_cpsCmd = N_cpsCmd;
        this.T_endprogram = T_endprogram;

    }

    @Override
    public abstractSyntaxTree.Program toAbstractSyntax() {
        return new abstractSyntaxTree.Program((Ident) T_ident, N_cpsCmd.toAbstractSyntax());
    }

}