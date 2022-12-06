package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMonOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* <monopr> ::= '~' */

public class MonOprNot extends Production implements IMonOpr {
    final IToken T_notOpr;

    public MonOprNot(final IToken T_notOpr) {
        this.T_notOpr = T_notOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_notOpr;
    }

}
