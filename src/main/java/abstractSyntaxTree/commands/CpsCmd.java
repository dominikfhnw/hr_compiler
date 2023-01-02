package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import java.util.ArrayList;
import java.util.HashMap;

// toString must be implemented

public class CpsCmd implements ICmd {
    ArrayList<ICmd> commands;

    public CpsCmd(ArrayList<ICmd> commands) {
        this.commands = commands;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        for (ICmd cmd : commands) {
            cmd.checkScope();
        }
    }

    @Override
    public void checkType() throws TypeCheckError {
        for (ICmd cmd : commands) {
            cmd.checkType();
        }
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