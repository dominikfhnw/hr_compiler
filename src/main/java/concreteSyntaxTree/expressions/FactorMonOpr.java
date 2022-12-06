package concreteSyntaxTree.expressions;

import abstractSyntaxTree.factors.MonFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IFactor;
import concreteSyntaxTree.interfaces.operators.IMonOpr;

/* <factor> ::= <monopr> <factor> */

public class FactorMonOpr extends Production implements IFactor {
    final IMonOpr N_monOpr;
    final IFactor N_mfactor;

    public FactorMonOpr(final IMonOpr N_monadicOpr, final IFactor N_mfactor) {
        this.N_monOpr = N_monadicOpr;
        this.N_mfactor = N_mfactor;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new MonFactor(N_monOpr.toAbstractSyntax(), N_mfactor.toAbstractSyntax());
    }
}