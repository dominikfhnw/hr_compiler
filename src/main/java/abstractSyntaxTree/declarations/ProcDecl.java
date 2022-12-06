package abstractSyntaxTree.declarations;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.parameterLists.Parameter;
import abstractSyntaxTree.interfaces.IDecl;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import java.util.ArrayList;

// methods must be implemented

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
