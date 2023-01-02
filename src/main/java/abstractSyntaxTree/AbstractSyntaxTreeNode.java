package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IAbstractSyntaxTreeNode;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;

import java.util.HashMap;

public class AbstractSyntaxTreeNode implements IAbstractSyntaxTreeNode {

    // Namespaces
    static HashMap<String, TypeIdent> globalVarNamespace = new HashMap<>();
    static HashMap<String, TypeIdent> localVarNamespace = new HashMap<>();

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        // do nothing
    }

    @Override
    public void checkType() throws TypeCheckError {
        // do nothing
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // do nothing
    }

}
