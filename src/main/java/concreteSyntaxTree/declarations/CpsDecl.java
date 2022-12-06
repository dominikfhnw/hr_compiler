package concreteSyntaxTree.declarations;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.ICpsDecl;
import concreteSyntaxTree.interfaces.ICpsDeclNTS;
import java.util.ArrayList;

/*
<cpsDecl> ::= <decl> {';' <decl>}
{';' <decl>} = cpsDeclNTS
*/

public class CpsDecl extends Production implements ICpsDecl {
    final IDecl N_decl;
    final ICpsDeclNTS N_cpsDeclNTS;

    public CpsDecl(final IDecl N_decl, final ICpsDeclNTS N_cpsDeclNTS) {
        this.N_decl = N_decl;
        this.N_cpsDeclNTS = N_cpsDeclNTS;
    }

    @Override
    public ArrayList<abstractSyntaxTree.interfaces.IDecl> toAbstractSyntax() {
        ArrayList<abstractSyntaxTree.interfaces.IDecl> temp = new ArrayList<>();
        temp.add(N_decl.toAbstractSyntax());
        return N_cpsDeclNTS.toAbstractSyntax(temp);
    }
}
