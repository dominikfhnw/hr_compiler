package concreteSyntaxTree.operators;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMonadicOpr;
import scanner.interfaces.IToken;
import scanner.operators.Operator;

// monadicOpr ::= NOT
public class MonadicOprNot extends Production implements IMonadicOpr {
    final IToken T_notOpr;

    public MonadicOprNot(IToken T_notOpr) {
        this.T_notOpr = T_notOpr;
    }

    @Override
    public Operator toAbstractSyntax() {
        return (Operator) T_notOpr;
    }

}
