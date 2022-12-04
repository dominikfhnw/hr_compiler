package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IFactor;
import scanner.enums.LRValue;
import scanner.enums.Types;
import scanner.operators.Operator;

// needs to be implemented

public class MonadicFactor implements IFactor {

    Operator monadicOpr;
    IFactor factor;
    Types castType;

    public MonadicFactor(Operator monadicOpr, IFactor factor) {
        this.monadicOpr = monadicOpr;
        this.factor = factor;
    }

    public MonadicFactor(Operator monadicOpr) {
        this.monadicOpr = monadicOpr;
    }

    @Override
    public Types getType() {
        return null;
    }

    @Override
    public LRValue getLRValue() {
        return null;
    }

    @Override
    public void doTypeCast(Types type) {

    }
}
