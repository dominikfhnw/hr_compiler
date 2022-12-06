package concreteSyntaxTree.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICpsStoDecl;
import concreteSyntaxTree.interfaces.ICpsStoDeclNTS;
import concreteSyntaxTree.interfaces.IStoDecl;
import java.util.ArrayList;

 /*
<cpsStoDecl> ::= <stoDecl> {';' <stoDecl>}
{';' <stoDecl>} = cpsStoDeclNTS
*/

public class CpsStoDecl extends Production implements ICpsStoDecl {
    final IStoDecl N_stoDecl;
    final ICpsStoDeclNTS N_cpsStoDeclNTS;

    public CpsStoDecl(final IStoDecl N_stoDecl, final ICpsStoDeclNTS N_cpsStoDeclNTS) {
        this.N_stoDecl = N_stoDecl;
        this.N_cpsStoDeclNTS = N_cpsStoDeclNTS;
    }

    @Override public ArrayList<StoDecl> toAbstractSyntax() {
        ArrayList<StoDecl> temp = new ArrayList<>();
        temp.add(N_stoDecl.toAbstractSyntax());
        return N_cpsStoDeclNTS.toAbstractSyntax(temp);
    }
}