package concreteSyntaxTree;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IParameterList;
import concreteSyntaxTree.interfaces.IProcDecl;
import concreteSyntaxTree.interfaces.IProcDeclNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

// procDecl ::= PROC IDENT paramList procDeclNTS DO cpsCmd ENDPROC
public class ProcDecl extends Production implements IProcDecl {
    final IToken T_proc;
    final IToken T_ident;
    final IParameterList N_parameterList;
    final IProcDeclNTS N_procDeclNTS;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endProc;

    public ProcDecl(IToken t_proc, IToken t_ident, IParameterList n_parameterList, IProcDeclNTS n_procDeclNTS, IToken t_do, ICpsCmd n_cpsCmd, IToken t_endProc) {
        T_proc = t_proc;
        T_ident = t_ident;
        T_do = t_do;
        T_endProc = t_endProc;
        N_parameterList = n_parameterList;
        N_procDeclNTS = n_procDeclNTS;
        N_cpsCmd = n_cpsCmd;
    }

    @Override
    public IDecl toAbstractSyntax() {
        return null;
    }

    /*
    @Override
    public IDecl toAbstractSyntax() {
        return new abstractSyntaxTree.ProcDecl((Ident) T_ident, N_parameterList.toAbstractSyntax(), N_procDeclNTS.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax());
    }
    */
}