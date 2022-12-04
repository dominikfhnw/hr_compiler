package abstractSyntaxTree.declarations;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.parameterLists.Parameter;
import abstractSyntaxTree.parameterLists.TypeIdent;
import abstractSyntaxTree.interfaces.IDecl;
import errors.AlreadyDeclaredError;
import errors.AlreadyInitializedError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import scanner.Ident;
import java.util.ArrayList;
import java.util.HashMap;

// needs to be implemented

public class ProcDecl implements IDecl {

    Ident ident;
    CpsCmd cpsCmd;
    ArrayList<Parameter> parameters;
    ArrayList<StoDecl> stoDecls;
    boolean initCheckDone = false;

    public ProcDecl(Ident ident, ArrayList<Parameter> parameters, ArrayList<StoDecl> stoDecls, CpsCmd cpsCmd) {
        this.ident = ident;
        this.parameters = parameters;
        this.stoDecls = stoDecls;
        this.cpsCmd = cpsCmd;
    }
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
}
