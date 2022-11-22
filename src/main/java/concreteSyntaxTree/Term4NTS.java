package concreteSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.ITerm4NTS;
import scanner.interfaces.IToken;

// term4NTS ::= CUSTOPR factor term4NTS

public class Term4NTS extends Production implements ITerm4NTS {

    final IToken T_custOpr;
    final IFactor N_factor;
    final ITerm4NTS N_term4NTS;

    public Term4NTS(IToken T_multOpr, IFactor N_factor, ITerm4NTS N_term4NTS) {
        this.T_custOpr = T_multOpr;
        this.N_factor = N_factor;
        this.N_term4NTS = N_term4NTS;
    }

    // needs to be implemented
    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        return null;
    }
}
