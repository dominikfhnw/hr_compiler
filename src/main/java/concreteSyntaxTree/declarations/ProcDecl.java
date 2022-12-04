package concreteSyntaxTree.declarations;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IParameterList;
import concreteSyntaxTree.interfaces.IProcDecl;
import concreteSyntaxTree.interfaces.IProcDeclNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

// procDecl ::= PROC IDENT parameterList procDeclNTS DO cpsCmd ENDPROC

public class ProcDecl extends Production implements IProcDecl {
    final IToken T_proc;
    final IToken T_ident;
    final IParameterList N_parameterList;
    final IProcDeclNTS N_procDeclNTS;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endProc;

    public ProcDecl(IToken T_proc, IToken T_ident, IParameterList N_parameterList, IProcDeclNTS N_procDeclNTS, IToken T_do, ICpsCmd N_cpsCmd, IToken T_endProc) {
        this.T_proc = T_proc;
        this.T_ident = T_ident;
        this.T_do = T_do;
        this.T_endProc = T_endProc;
        this.N_parameterList = N_parameterList;
        this.N_procDeclNTS = N_procDeclNTS;
        this.N_cpsCmd = N_cpsCmd;
    }

    @Override
    public IDecl toAbstractSyntax() {
        return new abstractSyntaxTree.declarations.ProcDecl((Ident) T_ident, N_parameterList.toAbstractSyntax(), N_procDeclNTS.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax());
    }

}