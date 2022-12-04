package concreteSyntaxTree;

import abstractSyntaxTree.MonadicFactor;
import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IMonadicOpr;

// factor ::= monadicOpr factor
public class FactorMonadicOpr extends Production implements IFactor {
    final IMonadicOpr N_monadicOpr;
    final IFactor N_mfactor;

    public FactorMonadicOpr(IMonadicOpr N_monadicOpr, IFactor N_mfactor) {
        this.N_monadicOpr = N_monadicOpr;
        this.N_mfactor = N_mfactor;
    }

    @Override
    public abstractSyntaxTree.interfaces.IFactor toAbstractSyntax() {
        return new MonadicFactor(N_monadicOpr.toAbstractSyntax(), N_mfactor.toAbstractSyntax());
    }
}