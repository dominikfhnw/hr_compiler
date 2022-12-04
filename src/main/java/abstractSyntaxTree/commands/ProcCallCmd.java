package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import scanner.Ident;

import java.util.ArrayList;

// needs to be implemented

public class ProcCallCmd implements ICmd {

    Ident ident;
    ArrayList<IExpression> expressions = new ArrayList<>();

    public ProcCallCmd(Ident ident, ArrayList<IExpression> expressions) {
        this.ident = ident;
        this.expressions = expressions;
    }

}
