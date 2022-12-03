package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IGlobalNTS;
import concreteSyntaxTree.interfaces.IProgram;
import scanner.Ident;
import scanner.interfaces.IToken;

// program ::= PROGRAM IDENT globalNTS DO cpsCmd ENDPROGRAM

public class Program extends Production implements IProgram {

    final IToken T_program;
    final IToken T_ident;
    final IGlobalNTS N_globalNTS;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endprogram;

    public Program(IToken T_program, IToken T_ident, IGlobalNTS N_globalNTS, IToken T_do, ICpsCmd N_cpsCmd, IToken T_endprogram) {

        this.T_program = T_program;
        this.T_ident = T_ident;
        this.N_globalNTS = N_globalNTS;
        this.T_do = T_do;
        this.N_cpsCmd = N_cpsCmd;
        this.T_endprogram = T_endprogram;

    }

    @Override
    public abstractSyntaxTree.Program toAbstractSyntax() {
        return null;
        //return new abstractSyntaxTree.Program((Ident) T_ident, N_globalNTS.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax());
    }

}