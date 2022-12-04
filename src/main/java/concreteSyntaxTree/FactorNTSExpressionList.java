package concreteSyntaxTree;

import abstractSyntaxTree.FunCallFactor;
import abstractSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IExpressionList;
import concreteSyntaxTree.interfaces.IFactorNTS;
import scanner.Ident;

// factorNTS ::= exprList

public class FactorNTSExpressionList extends Production implements IFactorNTS {

    final IExpressionList N_expressionList;

    public FactorNTSExpressionList(IExpressionList N_expressionList) {
        this.N_expressionList = N_expressionList;
    }

    @Override public IFactor toAbstractSyntax(Ident ident) {
        return new FunCallFactor(ident, N_expressionList.toAbstractSyntax());
    }
}
