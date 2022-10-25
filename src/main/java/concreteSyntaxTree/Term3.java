package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.ITerm3;
import concreteSyntaxTree.interfaces.ITerm3NTS;

public class Term3 extends Production implements ITerm3 {

    private final IFactor N_factor;
    private final ITerm3NTS N_term3NTS;

    public Term3(IFactor N_factor, ITerm3NTS N_term3NTS) {
        this.N_factor = N_factor;
        this.N_term3NTS = N_term3NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term3NTS.toAbstractSyntax(N_factor.toAbstractSyntax());
    }

}
