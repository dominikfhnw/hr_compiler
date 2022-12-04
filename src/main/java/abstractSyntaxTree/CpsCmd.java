package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.ICpsCmdNTS;
import java.util.ArrayList;

// needs to be implemented

public class CpsCmd implements ICmd {
    private ArrayList<ICmd> commands;

    public CpsCmd(ArrayList<ICmd> commands) {
        this.commands = commands;
    }

}