package concreteSyntaxTree.expressions;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ITerm1;
import concreteSyntaxTree.interfaces.ITerm1NTS;
import concreteSyntaxTree.interfaces.ITerm2;

/*
<term1> ::= <term2> [<relopr> <term2>]
[<relopr> <term2>] = term1NTS
*/

public class Term1 extends Production implements ITerm1 {

    final ITerm2 N_term2;
    final ITerm1NTS N_term1NTS;

    public Term1(ITerm2 N_term2, ITerm1NTS N_term1NTS) {
        this.N_term2 = N_term2;
        this.N_term1NTS = N_term1NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term1NTS.toAbstractSyntax(N_term2.toAbstractSyntax());
    }

}
