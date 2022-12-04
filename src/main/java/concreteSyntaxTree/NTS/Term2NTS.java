package concreteSyntaxTree.NTS;

import abstractSyntaxTree.expressions.AddExpression;
import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ITerm2NTS;
import concreteSyntaxTree.interfaces.ITerm3;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

// term2NTS ::= ADDOPR term3 term2NTS

public class Term2NTS extends Production implements ITerm2NTS {

    final IToken T_addOpr;
    final ITerm3 N_term3;
    final ITerm2NTS N_term2NTS;

    public Term2NTS(IToken T_addOpr, ITerm3 N_term3, ITerm2NTS N_term2NTS) {
        this.T_addOpr = T_addOpr;
        this.N_term3 = N_term3;
        this.N_term2NTS = N_term2NTS;
    }

    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
       IExpression temp = new AddExpression(((Operator) T_addOpr).getOperator(), expression, N_term3.toAbstractSyntax());
        return N_term2NTS.toAbstractSyntax(temp);
    }
}
