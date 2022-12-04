package concreteSyntaxTree;

import abstractSyntaxTree.StoDecl;
import concreteSyntaxTree.interfaces.IStoDecl;
import concreteSyntaxTree.interfaces.ITypedIdent;
import scanner.interfaces.IToken;

// stoDecl ::= CHANGEMODE typedIdent

public class StoDeclChangeMode extends Production implements IStoDecl {

    final IToken T_changeMode;
    final ITypedIdent N_typedIdent;

    public StoDeclChangeMode(IToken T_changeMode, ITypedIdent N_typedIdent) {
        this.T_changeMode = T_changeMode;
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public StoDecl toAbstractSyntax() {
        return new StoDecl();
        // return new StoDecl(((Changemode) T_changeMode).getChangemode(), N_typedIdent.toAbsSyntax()); needs to be fixed
    }
}
