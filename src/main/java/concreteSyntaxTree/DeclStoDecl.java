package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IStoDecl;

// decl ::= stoDecl
public class DeclStoDecl extends Production implements IDecl {
    final IStoDecl N_stoDecl;

    public DeclStoDecl(IStoDecl N_stoDecl) {
        this.N_stoDecl = N_stoDecl;
    }

    @Override
    public abstractSyntaxTree.interfaces.IDecl toAbstractSyntax() {
        return N_stoDecl.toAbstractSyntax();
    }
}
