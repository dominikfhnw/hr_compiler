package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class DebugInCmd implements ICmd {

    IExpression expression;

    public DebugInCmd(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
        if (expression.getLRValue() != LRValue.LVALUE)
            throw new LRValueError(LRValue.LVALUE, expression.getLRValue());
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
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
