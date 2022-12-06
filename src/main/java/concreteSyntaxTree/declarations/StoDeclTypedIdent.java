package concreteSyntaxTree.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.declarations.IStoDecl;
import concreteSyntaxTree.interfaces.parameterLists.ITypedIdent;

/* stoDecl ::= <typedIdent> */

public class StoDeclTypedIdent extends Production implements IStoDecl {

    final ITypedIdent N_typedIdent;

    public StoDeclTypedIdent(final ITypedIdent N_typedIdent) {
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public StoDecl toAbstractSyntax() {
        return new StoDecl(N_typedIdent.toAbstractSyntax());
    }
}
