package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IDecl;
import errors.AlreadyDeclaredError;
import errors.AlreadyInitializedError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import java.util.HashMap;

// needs to be specified and fully implemented

public class ProcDecl implements IDecl {
    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypedIdent> saveNamespace)
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
    public void setInit(TypedIdent ident) {

    }

    @Override
    public String getIdentString() {
        return null;
    }
}
