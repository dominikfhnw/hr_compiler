package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IRelOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* <relopr> ::= '=' | '/=' | '<' | '>' | '<=' | '>=' */

public class RelOpr extends Production implements IRelOpr {

    final IToken T_relOpr;

    public RelOpr(final IToken T_relOpr) {
        this.T_relOpr = T_relOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_relOpr;
    }

}
