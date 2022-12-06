package abstractSyntaxTree.factors;

import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;

// methods must be implemented

public class InitFactor extends IdentFactor {

    boolean init;

    public InitFactor(Ident ident, boolean init) {
        this.ident = ident;
        this.init = init;
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
    public void checkScope() throws NotDeclaredError, LRValueError {
    }

    @Override
    public void checkType() throws TypeCheckError {
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
