package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ITypedIdent;
import scanner.Ident;
import scanner.modesAndTypes.Type;
import scanner.interfaces.IToken;

// typedIdent ::= IDENT COLON TYPE

public class TypedIdent extends Production implements ITypedIdent {
    final IToken T_ident;
    final IToken T_colon;
    final IToken T_type;

    public TypedIdent(IToken T_ident, IToken T_colon, IToken T_type) {
        this.T_ident = T_ident;
        this.T_colon = T_colon;
        this.T_type = T_type;
    }

    @Override
    public abstractSyntaxTree.TypedIdent toAbstractSyntax() {
        return new abstractSyntaxTree.TypedIdent((Ident) T_ident, ((Type) T_type).getType());
    }
}
