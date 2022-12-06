package concreteSyntaxTree.declarations;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.declarations.IDecl;
import concreteSyntaxTree.interfaces.declarations.IProcDecl;

/* // decl ::= <procDecl> */

public class DeclProcDecl extends Production implements IDecl {

    final IProcDecl N_procDecl;

    public DeclProcDecl(final IProcDecl N_procDecl) {
        this.N_procDecl = N_procDecl;
    }

    @Override
    public abstractSyntaxTree.interfaces.IDecl toAbstractSyntax() {
        return N_procDecl.toAbstractSyntax();
    }
}
