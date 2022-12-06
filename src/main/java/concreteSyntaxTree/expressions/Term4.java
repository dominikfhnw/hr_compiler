package concreteSyntaxTree.expressions;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.*;

/*
<term4> ::= <factor> {<custopr> <factor>}
{<custopr> <factor>} = term4NTS
*/

public class Term4 extends Production implements ITerm4 {

    final IFactor N_factor;
    final ITerm4NTS N_term4NTS;

    public Term4(final IFactor N_factor, final ITerm4NTS N_term4NTS) {
        this.N_factor = N_factor;
        this.N_term4NTS = N_term4NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term4NTS.toAbstractSyntax(N_factor.toAbstractSyntax());
    }
}
