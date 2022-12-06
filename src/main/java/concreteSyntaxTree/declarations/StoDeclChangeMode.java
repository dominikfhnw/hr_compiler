package concreteSyntaxTree.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IStoDecl;
import concreteSyntaxTree.interfaces.ITypedIdent;
import scanner.interfaces.IToken;
import scanner.modesAndTypes.ChangeMode;

/* stoDecl ::= <changemode> <typedIdent> */

public class StoDeclChangeMode extends Production implements IStoDecl {

    final IToken T_changeMode;
    final ITypedIdent N_typedIdent;

    public StoDeclChangeMode(IToken T_changeMode, ITypedIdent N_typedIdent) {
        this.T_changeMode = T_changeMode;
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public StoDecl toAbstractSyntax() {
        return new StoDecl(((ChangeMode) T_changeMode).getChangeMode(), N_typedIdent.toAbstractSyntax());
    }
}
