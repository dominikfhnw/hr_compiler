package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ITerm2;
import concreteSyntaxTree.interfaces.ITerm2NTS;
import concreteSyntaxTree.interfaces.ITerm3;

public class Term2 extends Production implements ITerm2 {

    final ITerm3 N_term3;
    final ITerm2NTS N_term2NTS;

    public Term2(ITerm3 N_term3, ITerm2NTS N_term2NTS) {
        this.N_term3 = N_term3;
        this.N_term2NTS = N_term2NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term2NTS.toAbstractSyntax(N_term3.toAbstractSyntax());
    }

}
