package abstractSyntaxTree.declarations;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.interfaces.IDecl;
import abstractSyntaxTree.parameterLists.Parameter;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.Types;
import java.util.ArrayList;

// methods must be implemented

public class FunDecl implements IDecl {

    Ident ident;
    CpsCmd cpsCmd;
    ArrayList<Parameter> parameters;
    StoDecl stoDecl;
    ArrayList<StoDecl> stoDecls;

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
    public String getIdentString() {
        return null;
    }
}
