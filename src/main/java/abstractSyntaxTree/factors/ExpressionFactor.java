package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.interfaces.IFactor;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyInitializedError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.NotInitializedError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Types;

// needs to be implemented

public class ExpressionFactor implements IFactor {

    IExpression expression;
    Types castType;

    public ExpressionFactor(IExpression expression) {
        this.expression = expression;
    }

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
