package abstractSyntaxTree.interfaces;

import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.*;
import virtualMachine.interfaces.ICodeArray;

import java.util.HashMap;

public interface IAbstractSyntaxTreeNode {

    String toString(String indent);

    void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError;

    void checkScope() throws NotDeclaredError, LRValueError;

    void checkType() throws TypeCheckError;

    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly)
        throws ICodeArray.CodeTooSmallError;

}
