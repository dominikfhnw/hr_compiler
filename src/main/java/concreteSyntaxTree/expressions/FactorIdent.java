package concreteSyntaxTree.expressions;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IFactor;
import concreteSyntaxTree.interfaces.nts.IFactorNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

/*
<factor> ::= <ident> [init | <exprList>]
[init | <exprList>] = factorNTS
*/

public class FactorIdent extends Production implements IFactor {

    final IToken T_ident;
    final IFactorNTS N_factorNTS;

    public FactorIdent(final IToken T_ident, final IFactorNTS N_factorNTS) {
        this.T_ident = T_ident;
        this.N_factorNTS = N_factorNTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return N_factorNTS.toAbstractSyntax((Ident) T_ident);
    }
}
