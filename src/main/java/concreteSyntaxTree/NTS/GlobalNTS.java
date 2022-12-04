package concreteSyntaxTree.NTS;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsDecl;
import concreteSyntaxTree.interfaces.IGlobalNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

// globalNTS ::= GLOBAL cpsDecl

public class GlobalNTS extends Production implements IGlobalNTS {
    final IToken T_global;
    final ICpsDecl N_cpsDecl;

    public GlobalNTS(IToken T_global, ICpsDecl N_cpsDecl) {
        this.T_global = T_global;
        this.N_cpsDecl = N_cpsDecl;
    }

    @Override
    public ArrayList<IDecl> toAbstractSyntax() {
        return N_cpsDecl.toAbstractSyntax();
    }
}
