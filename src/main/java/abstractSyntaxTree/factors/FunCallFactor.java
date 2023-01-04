package abstractSyntaxTree.factors;

import abstractSyntaxTree.declarations.FunDecl;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.ArrayList;
import java.util.HashMap;

public class FunCallFactor extends IdentFactor {

    ArrayList<IExpression> expressions;

    public FunCallFactor(Ident ident, ArrayList<IExpression> expressions) {
        this.ident = ident;
        this.expressions = expressions;
    }

    @Override
    public Types getType() {
        // TODO: implement
        return null;
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: implement
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        // Check namespace
        // TODO: implement

        // Check scope
        for (IExpression expression : expressions) {
            expression.checkScope();
        }

    }

    @Override
    public void checkType() throws TypeCheckError {
        for (IExpression expression : expressions) {
            expression.checkType();
        }
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly)
        throws CodeTooSmallError {
            // TODO: implement
    }
}
