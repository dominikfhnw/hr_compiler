package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IFactor;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Types;
import scanner.operators.Operator;

// methods must be implemented

public class MonFactor implements IFactor {

    Operator monOpr;
    IFactor factor;

    public MonFactor(Operator monadicOpr, IFactor factor) {
        this.monOpr = monadicOpr;
        this.factor = factor;
    }

    public MonFactor(Operator monadicOpr) {
        this.monOpr = monadicOpr;
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
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {

    }

    @Override
    public void checkType() throws TypeCheckError {

    }

}
