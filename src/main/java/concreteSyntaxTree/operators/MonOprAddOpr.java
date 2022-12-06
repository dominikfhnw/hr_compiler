package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.operators.IMonOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/* <monopr> ::= <addopr> */

public class MonOprAddOpr extends Production implements IMonOpr {
    final IToken T_addOpr;

    public MonOprAddOpr(final IToken T_addOpr) {
        this.T_addOpr = T_addOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_addOpr;
    }
}