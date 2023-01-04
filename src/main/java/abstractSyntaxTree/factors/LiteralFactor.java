package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IFactor;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Literal;
import scanner.enums.LRValue;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

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
