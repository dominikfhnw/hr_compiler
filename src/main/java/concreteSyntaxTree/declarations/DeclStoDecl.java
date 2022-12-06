package concreteSyntaxTree.declarations;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.declarations.IDecl;
import concreteSyntaxTree.interfaces.declarations.IStoDecl;

/* decl ::= <stoDecl> */

public class DeclStoDecl extends Production implements IDecl {
    final IStoDecl N_stoDecl;

    public DeclStoDecl(final IStoDecl N_stoDecl) {
        this.N_stoDecl = N_stoDecl;
    }

    @Override
    public abstractSyntaxTree.interfaces.IDecl toAbstractSyntax() {
        return N_stoDecl.toAbstractSyntax();
    }
}
