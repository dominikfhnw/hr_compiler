package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;

import java.util.ArrayList;

// needs to be implemented

public class CpsCmd implements ICmd {
    private ArrayList<ICmd> commands;

    public CpsCmd(ArrayList<ICmd> commands) {
        this.commands = commands;
    }

}