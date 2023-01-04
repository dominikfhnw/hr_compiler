package abstractSyntaxTree.factors;

import abstractSyntaxTree.AbstractSyntaxTreeNode;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.interfaces.IFactor;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class ExpressionFactor extends AbstractSyntaxTreeNode implements IFactor {

    IExpression expression;

    public ExpressionFactor(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public Types getType() {
        return expression.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expression.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expression.checkType();
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly) throws CodeTooSmallError {
        // Add the value on top of the stack
        expression.addInstructionToCodeArray(localLocations, simulateOnly);
    }

    @Override
    public String toString(String indent) {
        // TODO: implement
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: implement
    }

}
