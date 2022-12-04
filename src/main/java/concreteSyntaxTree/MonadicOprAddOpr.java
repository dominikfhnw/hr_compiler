package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IMonadicOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

// monadicOpr ::= ADDOPR
public class MonadicOprAddOpr extends Production implements IMonadicOpr {
    final IToken T_addOpr;

    public MonadicOprAddOpr(IToken T_addOpr) {
        this.T_addOpr = T_addOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_addOpr;
    }
}