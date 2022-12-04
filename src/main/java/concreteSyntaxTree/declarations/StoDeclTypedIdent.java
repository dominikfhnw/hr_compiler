package concreteSyntaxTree.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IStoDecl;
import concreteSyntaxTree.interfaces.ITypedIdent;

// stoDecl ::= typedIdent

public class StoDeclTypedIdent extends Production implements IStoDecl {

    final ITypedIdent N_typedIdent;

    public StoDeclTypedIdent(ITypedIdent N_typedIdent) {
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public StoDecl toAbstractSyntax() {
        return new StoDecl(); // return new StoDecl(N_typedIdent.toAbstractSyntax()); needs to be fixed
    }
}
