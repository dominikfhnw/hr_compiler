package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IFactor;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Literal;
import scanner.enums.LRValue;
import scanner.enums.Types;

// toString must be implemented

public class LiteralFactor implements IFactor {
    Literal literal;

    public LiteralFactor(Literal literal) {
        this.literal = literal;
    }

    @Override
    public Types getType() {
        return literal.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        //
    }

    @Override
    public void checkType() throws TypeCheckError {
        //
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
