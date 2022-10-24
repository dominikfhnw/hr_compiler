package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.ITerm3;
import concreteSyntaxTree.interfaces.ITerm3NTS;

public class Term3 extends Production implements ITerm3 {

    private final IFactor factor;
    private final ITerm3NTS term3NTS;

    public Term3(IFactor factor, ITerm3NTS term3NTS) {
        this.factor = factor;
        this.term3NTS = term3NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return term3NTS.toAbstractSyntax(factor.toAbstractSyntax());
    }

}
