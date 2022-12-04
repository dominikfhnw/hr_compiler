package abstractSyntaxTree.interfaces;

import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.*;
import java.util.HashMap;

public interface IAbstractSyntaxTreeNode {

    String toString(String indent);

    void storeNamespace(HashMap<String, TypeIdent> saveNamespace) throws AlreadyDeclaredError, AlreadyInitializedError;

    void checkScope() throws NotDeclaredError;

    void checkType() throws TypeCheckError;

    void checkInit() throws NotInitializedError, AlreadyInitializedError;

    void setInit(TypeIdent ident);

}
