package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import java.util.ArrayList;

// toString must be implemented

public class CpsCmd implements ICmd {
    ArrayList<ICmd> commands;

    public CpsCmd(ArrayList<ICmd> commands) {
        this.commands = commands;
    }

    @Override
    public String toString(String indent) {
        return null;
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

}