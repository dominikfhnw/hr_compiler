package abstractSyntaxTree;

import abstractSyntaxTree.commands.CpsCmd;
import scanner.Ident;

// methods must be implemented

public class Program extends AbstractSyntaxTreeNode {

    Ident ident;
    CpsCmd cpsCmd;

    public Program(Ident ident, CpsCmd cpsCmd) {
        this.ident = ident;
        this.cpsCmd = cpsCmd;
    }

}
