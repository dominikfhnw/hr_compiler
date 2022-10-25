package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IFactorNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

public class FactorIdent extends Production implements IFactor {

    private final IToken T_ident;
    private final IFactorNTS N_factorNTS;

    public FactorIdent(IToken T_ident, IFactorNTS N_factorNTS) {
        this.T_ident = T_ident;
        this.N_factorNTS = N_factorNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return N_factorNTS.toAbstractSyntax((Ident) T_ident);
    }
}
