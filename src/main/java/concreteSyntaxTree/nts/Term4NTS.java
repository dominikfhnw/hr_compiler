package concreteSyntaxTree.nts;

import abstractSyntaxTree.expressions.CustExpression;
import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.ITerm4NTS;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* term4NTS ::= {<custopr> <factor>} */

public class Term4NTS extends Production implements ITerm4NTS {

    final IToken T_custOpr;
    final IFactor N_factor;
    final ITerm4NTS N_term4NTS;

    public Term4NTS(final IToken T_multOpr, final IFactor N_factor, final ITerm4NTS N_term4NTS) {
        this.T_custOpr = T_multOpr;
        this.N_factor = N_factor;
        this.N_term4NTS = N_term4NTS;
    }

    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        IExpression temp = new CustExpression(((Operator) T_custOpr).getOperator(), expression, N_factor.toAbstractSyntax());
        return N_term4NTS.toAbstractSyntax(temp);
    }
}
