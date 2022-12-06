package concreteSyntaxTree.parameterLists;

import abstractSyntaxTree.parameterLists.TypeIdent;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.parameterLists.ITypedIdent;
import scanner.Ident;
import scanner.modesAndTypes.Type;
import scanner.interfaces.IToken;

/* <typedIdent> ::= <ident> ':' <type> */

public class TypedIdent extends Production implements ITypedIdent {
    final IToken T_ident;
    final IToken T_colon;
    final IToken T_type;

    public TypedIdent(final IToken T_ident, final IToken T_colon, final IToken T_type) {
        this.T_ident = T_ident;
        this.T_colon = T_colon;
        this.T_type = T_type;
    }

    @Override
    public TypeIdent toAbstractSyntax() {
        return new TypeIdent((Ident) T_ident, ((Type) T_type).getType());
    }
}
