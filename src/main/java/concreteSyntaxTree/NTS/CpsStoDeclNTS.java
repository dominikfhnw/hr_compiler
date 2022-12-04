package concreteSyntaxTree.NTS;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsStoDeclNTS;
import concreteSyntaxTree.interfaces.IStoDecl;
import scanner.interfaces.IToken;
import java.util.ArrayList;

// cpsStoDeclNTS ::= SEMICOLON stoDecl cpsStoDeclNTS

public class CpsStoDeclNTS extends Production implements ICpsStoDeclNTS {
    final IToken T_semicolon;
    final IStoDecl N_stoDecl;
    final ICpsStoDeclNTS N_cpsStoDeclNTS;

    public CpsStoDeclNTS(IToken T_semicolon, IStoDecl N_stoDecl, ICpsStoDeclNTS N_cpsStoDeclNTS) {
        this.T_semicolon = T_semicolon;
        this.N_stoDecl = N_stoDecl;
        this.N_cpsStoDeclNTS = N_cpsStoDeclNTS;
    }

    @Override public ArrayList<StoDecl> toAbstractSyntax(ArrayList<StoDecl> temp) {
        temp.add(N_stoDecl.toAbstractSyntax());
        return N_cpsStoDeclNTS.toAbstractSyntax(temp);
    }
}