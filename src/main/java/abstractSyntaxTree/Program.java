package abstractSyntaxTree;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.interfaces.IDecl;
import scanner.Ident;
import java.util.ArrayList;

// needs to be implemented

public class Program extends AbstractSyntaxTreeNode {

    Ident ident;
    ArrayList<IDecl> globalDeclarations;
    CpsCmd cpsCmd;

    public Program(Ident ident, ArrayList<IDecl> globalDeclarations, CpsCmd cpsCmd) {
        this.ident = ident;
        this.globalDeclarations = globalDeclarations;
        this.cpsCmd = cpsCmd;
    }

}
