package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;

import java.util.HashMap;

public class MultExpression implements IExpression {

    Operators multOpr;
    IExpression expressionLeft;
    IExpression expressionRight;

    public MultExpression(Operators multOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.multOpr = multOpr;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public Types getType() {
        return expressionLeft.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        expressionLeft.checkScope();
        expressionRight.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        expressionLeft.checkType();
        expressionRight.checkType();
        if (expressionLeft.getType() == Types.BOOL) {
            throw new TypeCheckError(Types.INT32, expressionLeft.getType());
        } else if (expressionLeft.getType() != expressionRight.getType()) {
            throw new TypeCheckError(expressionLeft.getType(), expressionRight.getType());
        }
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
        // TODO: Implement
    }

}