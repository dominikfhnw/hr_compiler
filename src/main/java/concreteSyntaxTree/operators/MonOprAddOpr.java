package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMonOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

// monadicOpr ::= ADDOPR

public class MonOprAddOpr extends Production implements IMonOpr {
    final IToken T_addOpr;

    public MonOprAddOpr(IToken T_addOpr) {
        this.T_addOpr = T_addOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_addOpr;
    }
}