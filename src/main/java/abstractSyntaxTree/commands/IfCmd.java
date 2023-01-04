package abstractSyntaxTree.commands;

import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class IfCmd implements ICmd {

    IExpression expression;
    CpsCmd ifCpsCmd;
    CpsCmd elseCpsCmd;

    public IfCmd(IExpression expression, CpsCmd ifCpsCmd, CpsCmd elseCpsCmd) {
        this.expression = expression;
        this.ifCpsCmd = ifCpsCmd;
        this.elseCpsCmd = elseCpsCmd;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
        ifCpsCmd.checkScope();
        elseCpsCmd.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
        ifCpsCmd.checkType();
        elseCpsCmd.checkType();
        if (expression.getType() != Types.BOOL)
            throw new TypeCheckError(Types.BOOL, expression.getType());
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
