package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ITerm1;
import concreteSyntaxTree.interfaces.ITerm1NTS;
import concreteSyntaxTree.interfaces.ITerm2;

public class Term1 extends Production implements ITerm1 {

    private final ITerm2 term2;
    private final ITerm1NTS term1NTS;

    public Term1(ITerm2 term2, ITerm1NTS term1NTS) {
        this.term2 = term2;
        this.term1NTS = term1NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return term1NTS.toAbstractSyntax(term2.toAbstractSyntax());
    }

}
