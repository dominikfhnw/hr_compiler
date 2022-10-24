package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ITerm2;
import concreteSyntaxTree.interfaces.ITerm2NTS;
import concreteSyntaxTree.interfaces.ITerm3;

public class Term2 extends Production implements ITerm2 {

    private final ITerm3 term3;
    private final ITerm2NTS term2NTS;

    public Term2(ITerm3 term3, ITerm2NTS term2NTS) {
        this.term3 = term3;
        this.term2NTS = term2NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return term2NTS.toAbstractSyntax(term3.toAbstractSyntax());
    }

}
