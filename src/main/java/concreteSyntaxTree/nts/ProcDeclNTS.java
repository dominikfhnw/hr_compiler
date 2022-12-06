package concreteSyntaxTree.nts;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsStoDecl;
import concreteSyntaxTree.interfaces.IProcDeclNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

/* procDeclNTS ::= local <cpsStoDecl> */

public class ProcDeclNTS extends Production implements IProcDeclNTS {
    final IToken T_local;
    final ICpsStoDecl N_cpsStoDecl;

    public ProcDeclNTS(IToken T_local, ICpsStoDecl N_cpsStoDecl) {
        this.T_local = T_local;
        this.N_cpsStoDecl = N_cpsStoDecl;
    }

    @Override
    public ArrayList<StoDecl> toAbstractSyntax() {
        return N_cpsStoDecl.toAbstractSyntax();
    }
}