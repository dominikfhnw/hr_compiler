package abstractSyntaxTree.factors;

import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

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
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly) throws CodeTooSmallError {
            // TODO: implement
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: implement
    }

}
