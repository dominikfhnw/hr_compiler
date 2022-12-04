package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICpsDeclNTS;
import concreteSyntaxTree.interfaces.IDecl;
import scanner.interfaces.IToken;
import java.util.ArrayList;

// cpsDeclNTS ::= SEMICOLON decl cpsDeclNTS

public class CpsDeclNTS extends Production implements ICpsDeclNTS {
    final IToken T_semicolon;
    final IDecl N_decl;
    final ICpsDeclNTS N_cpsDeclNTS;

    public CpsDeclNTS(IToken T_semicolon, IDecl N_decl, ICpsDeclNTS N_cpsDeclNTS) {
        this.T_semicolon = T_semicolon;
        this.N_decl = N_decl;
        this.N_cpsDeclNTS = N_cpsDeclNTS;
    }

    @Override public ArrayList<abstractSyntaxTree.interfaces.IDecl> toAbstractSyntax(
        ArrayList<abstractSyntaxTree.interfaces.IDecl> temp) {
        temp.add(N_decl.toAbstractSyntax());
        return N_cpsDeclNTS.toAbstractSyntax(temp);
    }
}