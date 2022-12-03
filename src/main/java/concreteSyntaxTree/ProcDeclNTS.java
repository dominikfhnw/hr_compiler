package concreteSyntaxTree;

import abstractSyntaxTree.StoDecl;
import concreteSyntaxTree.interfaces.ICpsStoDecl;
import concreteSyntaxTree.interfaces.IProcDeclNTS;
import scanner.interfaces.IToken;

import java.util.ArrayList;

// procDeclNTS ::= LOCAL cpsStoDecl
public class ProcDeclNTS extends Production implements IProcDeclNTS {
    final IToken T_local;
    final ICpsStoDecl N_cpsStoDecl;

    public ProcDeclNTS(IToken t_local, ICpsStoDecl n_cpsStoDecl) {
        T_local = t_local;
        N_cpsStoDecl = n_cpsStoDecl;
    }

    @Override
    public ArrayList<StoDecl> toAbstractSyntax() {
        return N_cpsStoDecl.toAbstractSyntax();
    }
}