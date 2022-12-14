package concreteSyntaxTree.nts;

import abstractSyntaxTree.expressions.RelExpression;
import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.nts.ITerm1NTS;
import concreteSyntaxTree.interfaces.expressions.ITerm2;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* term1NTS ::= [<relopr> <term2>] */

public class Term1NTS extends Production implements ITerm1NTS {

    final IToken T_relOpr;
    final ITerm2 N_term2;
    final ITerm1NTS N_term1NTS;

    public Term1NTS(final IToken T_relOpr, final ITerm2 N_term2, final ITerm1NTS N_term1NTS) {
        this.T_relOpr = T_relOpr;
        this.N_term2 = N_term2;
        this.N_term1NTS = N_term1NTS;
    }

    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        IExpression temp = new RelExpression(((Operator) T_relOpr).getOperator(), expression, N_term2.toAbstractSyntax());
        return N_term1NTS.toAbstractSyntax(temp);
    }

}
