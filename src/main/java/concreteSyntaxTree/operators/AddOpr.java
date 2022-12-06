package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.operators.IAddOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* <addopr> ::= '+' | '-' */

public class AddOpr extends Production implements IAddOpr {

    final IToken T_addOpr;

    public AddOpr(final IToken T_addOpr) {
        this.T_addOpr = T_addOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_addOpr;
    }

}
