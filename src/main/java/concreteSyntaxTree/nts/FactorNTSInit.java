package concreteSyntaxTree.nts;

import abstractSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IFactorNTS;
import scanner.Ident;
import scanner.interfaces.IToken;

/* factorNTS ::= init */

public class FactorNTSInit extends Production implements IFactorNTS {

    final IToken T_init;

    public FactorNTSInit(final IToken T_init) {
        this.T_init = T_init;
    }

    @Override
    public IFactor toAbstractSyntax(Ident ident) {
        return null;
    }
}
