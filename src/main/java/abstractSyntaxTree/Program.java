package abstractSyntaxTree;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class Program extends AbstractSyntaxTreeNode {

    Ident ident;
    CpsCmd cpsCmd;

    public Program(Ident ident, CpsCmd cpsCmd) {
        this.ident = ident;
        this.cpsCmd = cpsCmd;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {

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
}
