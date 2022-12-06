package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import java.util.ArrayList;

// // methods must be implemented

public class ProcCallCmd implements ICmd {

    Ident ident;
    ArrayList<IExpression> expressions = new ArrayList<>();

    public ProcCallCmd(Ident ident, ArrayList<IExpression> expressions) {
        this.ident = ident;
        this.expressions = expressions;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
    }

    @Override
    public void checkType() throws TypeCheckError {
    }

    @Override
    public String toString(String indent) {
        return null;
    }


}
