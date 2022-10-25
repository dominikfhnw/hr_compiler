package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IFactorNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

public class FactorIdent extends Production implements IFactor {

    private final IToken ident;
    private final IFactorNTS factorNTS;

    public FactorIdent(IToken ident, IFactorNTS factorNTS) {
        this.ident = ident;
        this.factorNTS = factorNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return factorNTS.toAbstractSyntax((Ident) ident);
    }
}
