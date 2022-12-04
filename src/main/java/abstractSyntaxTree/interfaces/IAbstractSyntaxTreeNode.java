package abstractSyntaxTree.interfaces;

import abstractSyntaxTree.TypeIdent;
import errors.*;
import java.util.HashMap;

public interface IAbstractSyntaxTreeNode {

    public abstract String toString(String indent);

        public void storeNamespace(HashMap<String, TypeIdent> saveNamespace) throws AlreadyDeclaredError, AlreadyInitializedError;

        public void checkScope() throws NotDeclaredError;

        public void checkType() throws TypeCheckError;

        public void checkInit() throws NotInitializedError, AlreadyInitializedError;

        public void setInit(TypeIdent ident);

}
