package concreteSyntaxTree;

import abstractSyntaxTree.StoDecl;
import concreteSyntaxTree.interfaces.ICpsStoDecl;
import concreteSyntaxTree.interfaces.IFunDeclNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

// funDeclNTS ::= LOCAL cpsStoNTS

public class FunDeclNTS extends Production implements IFunDeclNTS {
    final IToken T_local;
    final ICpsStoDecl N_cpsStoDecl;

    public FunDeclNTS(IToken T_local, ICpsStoDecl N_cpsStoDecl) {
        this.T_local = T_local;
        this.N_cpsStoDecl = N_cpsStoDecl;
    }

    @Override
    public ArrayList<StoDecl> toAbstractSyntax() {
        return N_cpsStoDecl.toAbstractSyntax();
    }
}