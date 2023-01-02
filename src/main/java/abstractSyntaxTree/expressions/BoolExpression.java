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

import java.util.HashMap;

// toString must be implemented

public class BoolExpression implements IExpression {

    Operators boolOpr;
    IExpression expressionLeft;
    IExpression expressionRight;

    public BoolExpression(Operators boolOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.boolOpr = boolOpr;
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
        if (expressionLeft.getType() != Types.BOOL) {
            throw new TypeCheckError(Types.BOOL, expressionLeft.getType());
        } else if (expressionLeft.getType() != expressionRight.getType()) {
            throw new TypeCheckError(expressionLeft.getType(), expressionRight.getType());
        }
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
