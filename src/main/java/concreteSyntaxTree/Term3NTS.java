package concreteSyntaxTree;

import abstractSyntaxTree.AddExpression;
import abstractSyntaxTree.MultExpression;
import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.ITerm3NTS;
import concreteSyntaxTree.interfaces.ITerm4;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

// term3NTS ::= MULTOPR term4 term3NTS

public class Term3NTS extends Production implements ITerm3NTS{

    final IToken T_multOpr;
    final ITerm4 N_term4;
    final ITerm3NTS N_term3NTS;

    public Term3NTS(IToken T_addOpr, ITerm4 N_term4, ITerm3NTS N_term3NTS) {
        this.T_multOpr = T_addOpr;
        this.N_term4 = N_term4;
        this.N_term3NTS = N_term3NTS;
    }

    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        IExpression temp = new MultExpression(((Operator) T_multOpr).getOperator(), expression, N_term4.toAbstractSyntax());
        return N_term3NTS.toAbstractSyntax(temp);
    }
}
