package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IFactorNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

// factor ::= IDENT factorNTS

public class FactorIdent extends Production implements IFactor {

    final IToken T_ident;
    final IFactorNTS N_factorNTS;

    public FactorIdent(IToken T_ident, IFactorNTS N_factorNTS) {
        this.T_ident = T_ident;
        this.N_factorNTS = N_factorNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return N_factorNTS.toAbstractSyntax((Ident) T_ident);
    }
}
