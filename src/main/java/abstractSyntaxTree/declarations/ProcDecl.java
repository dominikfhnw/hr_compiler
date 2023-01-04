package abstractSyntaxTree.declarations;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.parameterLists.Parameter;
import abstractSyntaxTree.interfaces.IDecl;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcDecl implements IDecl {

    Ident ident;
    CpsCmd cpsCmd;
    ArrayList<Parameter> parameters;
    ArrayList<StoDecl> stoDecls;

    public ProcDecl(Ident ident, ArrayList<Parameter> parameters, ArrayList<StoDecl> stoDecls, CpsCmd cpsCmd) {
        this.ident = ident;
        this.parameters = parameters;
        this.stoDecls = stoDecls;
        this.cpsCmd = cpsCmd;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        cpsCmd.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        cpsCmd.checkType();
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly) throws CodeTooSmallError {
        // TODO: implement
    }

    @Override
    public String getIdentString() {
        return ident.getIdent();
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
