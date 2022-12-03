package concreteSyntaxTree;

// stoDecl ::= typedIdent

import abstractSyntaxTree.StoDecl;
import concreteSyntaxTree.interfaces.IStoDecl;
import concreteSyntaxTree.interfaces.ITypedIdent;

public class StoDeclTypedIdent extends Production implements IStoDecl {

    final ITypedIdent N_typedIdent;

    public StoDeclTypedIdent(ITypedIdent N_typedIdent) {
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public StoDecl toAbstractSyntax() {
        return new StoDecl(); // should return new StoDecl(N_typedIdent.toAbstractSyntax()); needs to be implemented in StoDecl
    }
}
