package concreteSyntaxTree.nts;

import abstractSyntaxTree.factors.FunCallFactor;
import abstractSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.expressions.IExpressionList;
import concreteSyntaxTree.interfaces.nts.IFactorNTS;
import scanner.Ident;

/* factorNTS ::= <exprList> */

public class FactorNTSExpressionList extends Production implements IFactorNTS {

    final IExpressionList N_expressionList;

    public FactorNTSExpressionList(final IExpressionList N_expressionList) {
        this.N_expressionList = N_expressionList;
    }

    @Override public IFactor toAbstractSyntax(Ident ident) {
        return new FunCallFactor(ident, N_expressionList.toAbstractSyntax());
    }
}
