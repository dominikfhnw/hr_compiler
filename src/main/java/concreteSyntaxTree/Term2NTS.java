package concreteSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import concreteSyntaxTree.interfaces.ITerm2NTS;
import concreteSyntaxTree.interfaces.ITerm3;
import scanner.interfaces.IToken;

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

    // needs to be implemented
    @Override
    public IExpression toAbstractSyntax(IExpression expression) {
        return null;
    }
}
