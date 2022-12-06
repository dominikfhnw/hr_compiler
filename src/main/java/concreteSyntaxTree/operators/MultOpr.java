package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMultOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

/*
<multopr> ::= '*' | <divopr>
<divopr> ::= 'divT' | 'modT'
*/

public class MultOpr extends Production implements IMultOpr {

    final IToken T_multOpr;

    public MultOpr(IToken T_multOpr) {
        this.T_multOpr = T_multOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_multOpr;
    }
}
