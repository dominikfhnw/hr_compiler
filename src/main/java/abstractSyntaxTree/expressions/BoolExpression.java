package abstractSyntaxTree.expressions;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyInitializedError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;

public class BoolExpression implements IExpression {

    Operators boolOpr;
    IExpression expressionLeft;
    IExpression expressionRight;
    Types castType;

    public BoolExpression(Operators boolOpr, IExpression expressionLeft, IExpression expressionRight) {
        this.boolOpr = boolOpr;
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    // needs to be implemented

    @Override
    public Types getType() {
        return null;
    }

    @Override
    public LRValue getLRValue() {
        return null;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {

    }

    @Override
    public void checkType() throws TypeCheckError {

    }

    @Override
    public void checkInit() throws NotInitializedError, AlreadyInitializedError {

    }

    @Override
    public void setInit(TypeIdent ident) {

    }
}
