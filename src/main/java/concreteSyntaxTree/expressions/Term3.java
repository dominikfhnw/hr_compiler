package concreteSyntaxTree.expressions;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ITerm3;
import concreteSyntaxTree.interfaces.ITerm3NTS;
import concreteSyntaxTree.interfaces.ITerm4;

/*
<term3> ::= <term4> {<multopr> <term4>}
{<multopr> <term4>} = term3NTS
*/

public class Term3 extends Production implements ITerm3 {

    final ITerm4 N_term4;
    final ITerm3NTS N_term3NTS;

    public Term3(ITerm4 N_term4, ITerm3NTS N_term3NTS) {
        this.N_term4 = N_term4;
        this.N_term3NTS = N_term3NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term3NTS.toAbstractSyntax(N_term4.toAbstractSyntax());
    }

}
