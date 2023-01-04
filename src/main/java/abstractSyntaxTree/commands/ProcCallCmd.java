package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import java.util.ArrayList;
import java.util.HashMap;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;

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
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly) throws CodeTooSmallError {
        // TODO: Implement
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
