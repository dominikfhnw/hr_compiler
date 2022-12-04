package abstractSyntaxTree.declarations;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.interfaces.IDecl;
import abstractSyntaxTree.parameterLists.Parameter;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyInitializedError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.Types;
import java.util.ArrayList;

// needs to be implemented

public class FunDecl implements IDecl {

    Ident ident;
    CpsCmd cpsCmd;
    ArrayList<Parameter> parameters;
    StoDecl stoDecl;
    ArrayList<StoDecl> stoDecls;
    boolean initCheckDone = false;

    public FunDecl(Ident ident, ArrayList<Parameter> parameters, StoDecl stoDecl, ArrayList<StoDecl> stoDecls, CpsCmd cpsCmd) {
        this.ident = ident;
        this.cpsCmd = cpsCmd;
        this.stoDecl = stoDecl;
        this.parameters = parameters;
        this.stoDecls = stoDecls;
    }

    public Types getReturnType() {
        return stoDecl.getTypeIdent().getType();
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public boolean getInitCheckDone() {
        return initCheckDone;
    }

    public void setInitCheckDone() {
        this.initCheckDone = true;
    }

    @Override
    public String toString(String indent) {
        return null;
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
