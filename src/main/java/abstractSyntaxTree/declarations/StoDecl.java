package abstractSyntaxTree.declarations;

import abstractSyntaxTree.parameterLists.TypeIdent;
import abstractSyntaxTree.interfaces.IDecl;
import errors.AlreadyDeclaredError;
import errors.AlreadyInitializedError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import java.util.HashMap;

// needs to be implemented

public class StoDecl implements IDecl {

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> saveNamespace)
        throws AlreadyDeclaredError, AlreadyInitializedError {
    }

    @Override
    public void checkScope() throws NotDeclaredError {

    }

    @Override
    public void checkType() throws TypeCheckError {

    }

    @Override
    public void checkInit() throws NotInitializedError, AlreadyInitializedError {

    }

    @Override
    public void setInit(TypeIdent ident) {

    }

    @Override
    public String getIdentString() {
        return null;
    }

    // Needs to be implemented

}
