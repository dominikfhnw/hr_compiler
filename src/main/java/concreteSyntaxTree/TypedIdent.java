package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ITypedIdent;
import scanner.Ident;
import scanner.modesAndTypes.Type;
import scanner.interfaces.IToken;

public class TypedIdent extends Production implements ITypedIdent {
    private final IToken ident;
    private final IToken colon;
    private final IToken type;

    public TypedIdent(IToken ident, IToken colon, IToken type) {
        this.ident = ident;
        this.colon = colon;
        this.type = type;
    }

    @Override
    public abstractSyntaxTree.TypedIdent toAbstractSyntax() {
        return new abstractSyntaxTree.TypedIdent((Ident) ident, ((Type) type).getType());
    }
}
