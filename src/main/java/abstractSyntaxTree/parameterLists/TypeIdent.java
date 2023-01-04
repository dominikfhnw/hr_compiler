package abstractSyntaxTree.parameterLists;

import abstractSyntaxTree.AbstractSyntaxTreeNode;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class TypeIdent extends AbstractSyntaxTreeNode {

    Ident ident;
    Types type;
    boolean isConst;

    private boolean needToDeref;

    public TypeIdent(Ident ident, Types type) {
        this.ident = ident;
        this.type = type;
    }

    public Ident getIdent() {
        return ident;
    }

    public String getValue() {
        return ident.getIdent();
    }

    public Types getType() {
        return type;
    }

    public void setConst() {
        this.isConst = true;
    }

    public boolean getConst() {
        return isConst;
    }

    public void setNeedToDeref() {
        this.needToDeref = true;
    }

    public boolean getNeedToDeref() {
        return needToDeref;
    }

    @Override
    public String toString(String indent) {
        //TODO: implement
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: Implement
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        // do nothing
    }

    @Override
    public void checkType() throws TypeCheckError {
        // do nothing
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly)
        throws CodeTooSmallError {
            // do nothing
    }

}
