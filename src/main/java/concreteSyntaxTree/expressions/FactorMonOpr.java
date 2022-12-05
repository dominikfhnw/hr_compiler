package concreteSyntaxTree.expressions;

import abstractSyntaxTree.factors.MonFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IMonOpr;

// factor ::= monadicOpr factor
public class FactorMonOpr extends Production implements IFactor {
    final IMonOpr N_monadicOpr;
    final IFactor N_mfactor;

    public FactorMonOpr(IMonOpr N_monadicOpr, IFactor N_mfactor) {
        this.N_monadicOpr = N_monadicOpr;
        this.N_mfactor = N_mfactor;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new MonFactor(N_monadicOpr.toAbstractSyntax(), N_mfactor.toAbstractSyntax());
    }
}